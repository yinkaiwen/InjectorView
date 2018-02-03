package com.example.kevin.injectorviewapi;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.View;

import com.example.kevin.injectorview.invoketarget.InjectorTarget;
import java.lang.reflect.Field;

import static com.example.kevin.injectorview.annotation.Injector.INJECTOR;

/**
 * Created by kevin on 2018/2/3.
 * https://github.com/yinkaiwen
 */

public class BindView {

    public static void injector(Activity activity) {
        InjectorTarget<Activity> target = getTarget(activity.getClass());
        if (target != null) {
            target.injector(activity);
        } else {
            throw new RuntimeException("Not found generated class.");
        }

    }

    private static <T> InjectorTarget getTarget(Class<T> cls) {
        InjectorTarget<T> target = null;
        String targetName = cls.getName() + INJECTOR;
        try {
            Class<?> targetClass = Class.forName(targetName);
            target = (InjectorTarget<T>) targetClass.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return target;
    }

    public static void injector(Fragment fragment,View rootView) {
        InjectorTarget<Fragment> handler = (InjectorTarget<Fragment>) getTarget(fragment.getClass());
        if(setRootViewBeforeAuto(fragment,rootView)){
            handler.injector(fragment);
        }
    }


    private static boolean setRootViewBeforeAuto(Fragment fragment, View rootView){
        Class<? extends Fragment> cls = fragment.getClass();
        try {
            Field mView = cls.getSuperclass().getDeclaredField("mView");
            mView.setAccessible(true);
            mView.set(fragment,rootView);
            return true;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return false;
    }
}
