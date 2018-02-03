package com.example.kevin.injectorviewapi;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by kevin on 2018/2/3.
 * https://github.com/yinkaiwen
 */

public class ViewFinder {

    public static <T extends View> T findViewById(Activity activity, int id) {
        return (T) activity.findViewById(id);
    }

    public static <T extends View> T findViewById(Fragment fragment, int id) {
        View view = fragment.getView();
        return (T) view.findViewById(id);
    }
}
