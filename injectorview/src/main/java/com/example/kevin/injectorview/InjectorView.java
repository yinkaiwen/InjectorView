package com.example.kevin.injectorview;

import android.app.Activity;

import com.example.kevin.injectorview.invoketarget.InjectorTarget;

/**
 * Created by kevin on 2018/2/2.
 * https://github.com/yinkaiwen
 */

public class InjectorView {
    public static final String INJECTOR = "Injector";

    public static void injector(Activity activity) {
        InjectorTarget target = getTarget(activity.getClass());
        if (target != null){
            target.injector(activity);
        }else{
            throw new RuntimeException("Not found generated class.");
        }

    }

    private static InjectorTarget getTarget(Class<?> cls) {
        InjectorTarget target = null;
        String targetName = cls.getName() + INJECTOR;
        try {
            Class<?> targetClass = Class.forName(targetName);
            target = (InjectorTarget) targetClass.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return target;
    }
}
