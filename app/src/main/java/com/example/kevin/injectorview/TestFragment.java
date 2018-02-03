package com.example.kevin.injectorview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kevin.injectorviewapi.BindView;

/**
 * Created by kevin on 2018/2/3.
 * https://github.com/yinkaiwen
 */

public class TestFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        BindView.injector(this,view);
        return view;
    }
}
