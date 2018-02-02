package com.example.kevin.injectorview.handler;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;

/**
 * Created by kevin on 2018/2/2.
 * https://github.com/yinkaiwen
 * <p>
 * Class name is Annotation's Name + Handler.
 * Such as : InjectorHandler.
 */

public interface AnnotationHandler {
    void handle(RoundEnvironment roundEnv);

    void attachProcessor(ProcessingEnvironment environment);
}
