package com.example.kevin.injectorview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.example.kevin.injectorview.annotation.Injector;
import com.example.kevin.injectorviewapi.BindView;

/**
 * Created by kevin on 2018/2/3.
 * https://github.com/yinkaiwen
 */

public class FragmentTestActivity extends FragmentActivity {

    @Injector(R.id.frame_layout)
    FrameLayout mFrameLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        BindView.injector(this);

        setFragment();
    }

    private void setFragment() {
        TestFragment fragment = new TestFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frame_layout,fragment);
        transaction.commit();
//        mFrameLayout.
    }
}
