package com.example.kevin.injectorview;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.kevin.injectorview.annotation.Injector;
import com.example.kevin.injectorviewapi.BindView;

public class MainActivity extends AppCompatActivity {

    @Injector(R.id.btn_set)
    Button mButton;
    @Injector(R.id.et_text)
    EditText mEditText;
    @Injector(R.id.tv_info)
    TextView mTextView;
    @Injector(R.id.ib_button)
    ImageButton mImageButton;
    @Injector(R.id.layout)
    ConstraintLayout mLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BindView.injector(this);
        mTextView.setText("Success");

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TestActivity.class));
            }
        });
    }

}
