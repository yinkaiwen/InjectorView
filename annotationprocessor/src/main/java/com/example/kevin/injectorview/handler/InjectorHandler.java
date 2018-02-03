package com.example.kevin.injectorview.handler;

import com.example.kevin.injectorview.annotation.Injector;
import com.example.kevin.injectorview.javabean.InjectorInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;

/**
 * Created by kevin on 2018/2/2.
 * https://github.com/yinkaiwen
 */

public class InjectorHandler extends AbsHandler {
    private Map<String, InjectorInfo> map = new HashMap<>();

    @Override
    public void handle(RoundEnvironment roundEnv) {
        Set<? extends Element> elementsAnnotatedWith = roundEnv.getElementsAnnotatedWith(Injector.class);
        if (elementsAnnotatedWith != null && !elementsAnnotatedWith.isEmpty()) {
            for (Element element : elementsAnnotatedWith) {
                String className = element.getEnclosingElement().getSimpleName().toString();

                Element enclosingElement = element.getEnclosingElement();
                TypeMirror typeMirror = enclosingElement.asType();
                System.out.println(typeMirror.toString());
                String pkName = mElementsUtils.getPackageOf(element).getQualifiedName().toString();
                String key = pkName + className;
                InjectorInfo info = map.get(key);
                if (info == null) {
                    info = new InjectorInfo(pkName, className);
                    map.put(key, info);
                }
                VariableElement var = (VariableElement) element;
                String fieldName = var.getSimpleName().toString();
                int id = var.getAnnotation(Injector.class).value();
                info.values.put(fieldName, id);
            }
        }
        mJavaFileWriter.write(map,mFiler);
    }
}
