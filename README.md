# InjectorView
You can use this lib such as:
```
public class MainActivity extends AppCompatActivity {

    @Injector(R.id.tv_info)
    TextView mTextView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BindView.injector(this);
        mTextView.setText("Success");
    }

}
```
or use this in Fragment(V4):
```
public class TestFragment extends Fragment {

    @Injector(R.id.tv_fragment)
    TextView mTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        BindView.injector(this,view);
        mTextView.setText("success");
        return view;
    }
}
```

annotationprocessor lib's build.gradle code is fellow.
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

java lib can not use android api safe,so create a android lib and can use android api.This android-lib build.gradle is fellow.
```
dependencies {
    //pass....
    
    annotationProcessor project(':annotationprocessor')
    implementation project(':annotationprocessor')
}

```
