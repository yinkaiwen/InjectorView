package com.example.kevin.injectorview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kevin.injectorview.annotation.Injector;
import com.example.kevin.injectorviewapi.BindView;

/**
 * Created by kevin on 2018/2/2.
 * https://github.com/yinkaiwen
 */

public class TestActivity extends Activity {

    @Injector(R.id.tv_test)
    TextView mTextView;
    @Injector(R.id.btn_fragment)
    Button mButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        BindView.injector(this);
        mTextView.setText("success");
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TestActivity.this, FragmentTestActivity.class));
            }
        });
    }
}
