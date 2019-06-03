# CarbonImpact

## Repository structure
    ├── CarbonImpact (stores the source code, tests and build tools  of the app.)  
    |   ├── app  
    |   |   ├── src  
    |   |   |   ├── main (contains the source code)  
    |   |   |   |   ├── AndroidManifest.xml (is the Manifest file, which namely presents the permission and features restriction of the application [4](https://developer.android.com/guide/topics/manifest/manifest-intro))  
    |   |   |   |   ├── java/carbon/impact/carbonimpact (stores the Java classes of the application)  
    |   |   |   |   └── res (is the resources folder of the application)  
    |   |   |   |       ├── <drawable folders> (store the image files regarding the device's dpi/orientation/version/etc)  
    |   |   |   |       ├── <mipmap folders> (store the app's icons regarding the device's dpi ("mdpi" is approximately "160 dpi", "hdpi" is approximately "240 dpi", "xhdpi" is approximately "320 dpi", etc))  
    |   |   |   |       ├── layout (stores the XML files describing the views' content)  
    |   |   |   |       ├── menu (stores the XML files describing the menus' content)  
    |   |   |   |       ├── raw (stores raw files (such as musics or HTML files))  
    |   |   |   |       └── values (stores the other ressources (such as Strings))  
    |   |   |   ├── androidTest/java/carbon/impact/carbonimpact (regroups the Instrumented tests)  
    |   |   |   └── test/java/carbon/impact/carbonimpact (regroups the Unit tests)  
    |   |   ├── build.gradle (is used to configure the build of the Android application (it namely specifies the SDK version, the code version or the versions of the dependencies))  
    |   |   └── proguard-rules.pro (lists rules to use the compile-time code optimization tool ProGuard [2](http://developer.android.com/guide/developing/tools/proguard.html))  
    |   ├── gradle (regroups files to use the build automation tool gradle [1](https://gradle.org/))  
    |   └── <gradle files> (regroups files to use the build automation tool gradle [1](https://gradle.org/))  
    └── Documents (stores all the documents relative to the app (for instance, images or use case description))  

## Used tools
* Android Studio [[5]](https://developer.android.com/studio)

## References
* [1] Gradle - https://gradle.org/
* [2] ProGuard use in Android applciation - http://developer.android.com/guide/developing/tools/proguard.html
* [3] Android build configuration - https://developer.android.com/studio/build/
* [4] Manifest file - https://developer.android.com/guide/topics/manifest/manifest-intro
* [5] Android Studio - https://developer.android.com/studio
