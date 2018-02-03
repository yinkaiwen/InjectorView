package com.example.kevin.injectorview.writer;

import com.example.kevin.injectorview.javabean.InjectorInfo;

import java.util.Map;

import javax.annotation.processing.Filer;

/**
 * Created by kevin on 2018/2/2.
 * https://github.com/yinkaiwen
 */

public interface JavaFileWriter {
    void write(Map<String,InjectorInfo> map, Filer filer);
}
