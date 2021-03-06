package com.example.kevin.injectorview.writer;

import com.example.kevin.injectorview.invoketarget.InjectorTarget;
import com.example.kevin.injectorview.javabean.InjectorInfo;
import com.squareup.javapoet.ClassName;

import java.io.IOException;
import java.io.Writer;
import java.util.Calendar;
import java.util.Map;

import javax.annotation.processing.Filer;
import javax.lang.model.element.Element;
import javax.tools.JavaFileObject;

import static com.example.kevin.injectorview.annotation.Injector.INJECTOR;

/**
 * Created by kevin on 2018/2/2.
 * https://github.com/yinkaiwen
 */

public class DefaultWriter implements JavaFileWriter {

    private static final String ViewFinderTag = "com.example.kevin.injectorviewapi.ViewFinder";

    @Override
    public void write(Map<String, InjectorInfo> map, Filer filer) {
        if (!map.isEmpty()) {
            for (Map.Entry<String, InjectorInfo> entry : map.entrySet()) {
                InjectorInfo info = entry.getValue();
                String javaString = getJavaString(info);
//                System.out.println(javaString);
                Writer writer = null;
                try {
                    JavaFileObject sourceFile = filer.createSourceFile(getSrc(info), new Element[]{});
                    writer = sourceFile.openWriter();
                    writer.write(javaString);
                    writer.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (writer != null) {
                            writer.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    private String getJavaString(InjectorInfo info) {
        StringBuilder sb = new StringBuilder();

        String title = String.format("package %s;\n" +
                        "\n" +
                        "import android.app.Activity;\n" +
                        "import %s;\n" +
                        "import %s;\n" +
                        "\n" +
                        "/**\n" +
                        " * Created by kevin on %s.\n" +
                        " * https://github.com/yinkaiwen\n" +
                        " * \n" +
                        " * This class is generated by Processor.You should not change this.\n" +
                        " */\n" +
                        "\n",
                info.pkName,
                InjectorTarget.class.getName(),
                ViewFinderTag,
                getDate()
        );
        sb.append(title);

        String content = String.format("public class %s%s<T> implements InjectorTarget<T> {\n" +
                        "\n" +
                        "    @Override\n" +
                        "    public void injector(T target) {\n" +
                        "        %s a = (%s) target;\n",
                info.className,
                INJECTOR,
                info.className,
                info.className);
        sb.append(content);

        Map<String, Integer> values = info.values;
        for (Map.Entry<String, Integer> entry : values.entrySet()) {
            String fieldName = entry.getKey();
            int id = entry.getValue();
            sb.append(String.format("        a.%s = ViewFinder.findViewById(%s,%s);\n",
                    fieldName,
                    "a",
                    id
            ));
        }

        String end = "    }\n" +
                "\n" +
                "}";
        sb.append(end);
        return sb.toString();
    }

    private String getDate() {
        Calendar calendar = Calendar.getInstance();
        return String.format("%s/%s/%s", calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
    }

    private String getSrc(InjectorInfo injectorInfo) {
        return injectorInfo.pkName + "." + injectorInfo.className + INJECTOR;
    }



}
