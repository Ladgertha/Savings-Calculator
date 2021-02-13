// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath(ClassPath.gradle)
        classpath(ClassPath.kotlin)
        classpath(ClassPath.googleServices)
        classpath(ClassPath.crashlytics)
        classpath(ClassPath.performance)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}
