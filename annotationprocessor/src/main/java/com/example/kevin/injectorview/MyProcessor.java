package com.example.kevin.injectorview;

import com.example.kevin.injectorview.annotation.Injector;
import com.example.kevin.injectorview.handler.InjectorHandler;
import com.google.auto.service.AutoService;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;

/**
 * Created by kevin on 2018/2/2.
 * https://github.com/yinkaiwen
 */
@AutoService(Processor.class)
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes("com.example.kevin.injectorview.annotation.Injector")
public class MyProcessor extends AbstractProcessor {

    private List<Class<?>> mAnnotationClass = new LinkedList<>();
    private static final String HANDLER_STR = "Handler";

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        addAnnotation();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Class<?> cls : mAnnotationClass) {
            InjectorHandler handler = getHandler(cls);
            if (handler != null) {
                handler.attachProcessor(processingEnv);
                handler.handle(roundEnv);
            }
        }

        return true;
    }

    private InjectorHandler getHandler(Class<?> cls) {
        String targetHandlerName =
                InjectorHandler.class.getPackage().getName() + "." + cls.getSimpleName() + HANDLER_STR;
        try {
            Class<?> targetClass = Class.forName(targetHandlerName);
            return (InjectorHandler) targetClass.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void addAnnotation() {
        mAnnotationClass.add(Injector.class);
    }
}
