# InjectorView
You can use this lib such as:
```
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

        InjectorView.injector(this);
        mTextView.setText("Success");

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}
```

injectorview lib's build.gradle code is fellow.
```
apply plugin: 'java'//This module this java not java-library.

dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])

    implementation 'com.google.auto.service:auto-service:1.0-rc3'
    implementation 'com.squareup:javapoet:1.9.0'
    compile 'com.google.android:android:4.1.1.4'
}

sourceCompatibility = "1.8"
targetCompatibility = "1.8"
tasks.withType(JavaCompile) {
    options.encoding = "UTF-8"
}

```

app build.gradle core code is fellow
```
dependencies {
    //......

    //You can copy this format in you project(All of Processor code written in java project injectorview)
    annotationProcessor project(':injectorview')
    implementation project(':injectorview')
}
```
