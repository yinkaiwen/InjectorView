# InjectorView
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
