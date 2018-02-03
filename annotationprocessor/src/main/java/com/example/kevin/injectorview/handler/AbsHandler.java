package com.example.kevin.injectorview.handler;

import com.example.kevin.injectorview.writer.DefaultWriter;
import com.example.kevin.injectorview.writer.JavaFileWriter;

import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.util.Elements;

/**
 * Created by kevin on 2018/2/2.
 * https://github.com/yinkaiwen
 */

public abstract class AbsHandler implements AnnotationHandler {
    private ProcessingEnvironment mProcessingEnvironment;
    Elements mElementsUtils;
    Filer mFiler;
    JavaFileWriter mJavaFileWriter;

    public abstract void handle(RoundEnvironment roundEnv);

    @Override
    public void attachProcessor(ProcessingEnvironment environment) {
        mProcessingEnvironment = environment;
        mElementsUtils = mProcessingEnvironment.getElementUtils();
        mFiler = mProcessingEnvironment.getFiler();
        mJavaFileWriter = new DefaultWriter();
    }

    public void setJavaFileWriter(JavaFileWriter writer){
        mJavaFileWriter = writer;
    }
}
