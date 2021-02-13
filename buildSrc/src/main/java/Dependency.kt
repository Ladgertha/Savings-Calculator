object PluginVersion {
    const val kotlin = "1.3.61"
    const val gradle = "4.1.0"
    const val googleServices = "4.3.5"
    const val crashlytics = "2.5.0"
    const val performance = "1.3.4"
}

object Plugin {
    const val ANDROID_APPLICATION = "com.android.application"
    const val KOTLIN_ANDROID = "org.jetbrains.kotlin.android"
    const val GOOGLE_SERVICES = "com.google.gms.google-services"
    const val CRASHLYTICS = "com.google.firebase.crashlytics"
    const val PERFORMANCE = "com.google.firebase.firebase-perf"
}

object ClassPath {
    const val gradle = "com.android.tools.build:gradle:${PluginVersion.gradle}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${PluginVersion.kotlin}"
    const val googleServices = "com.google.gms:google-services:${PluginVersion.googleServices}"
    const val crashlytics = "com.google.firebase:firebase-crashlytics-gradle:${PluginVersion.crashlytics}"
    const val performance = "com.google.firebase:perf-plugin:${PluginVersion.performance}"
}

object AppData {
    const val buildToolsVersion = "29.0.0"
    const val compileSdkVersion = 29
    const val targetSdkVersion = 29
    const val minSdkVersion = 19

    const val versionCode = 1
    const val versionName = "1.0.0"

    const val applicationId = "ru.ladgertha.savingscalculator"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object Versions {
    const val kotlin = "1.3.50"
    const val androidX = "1.1.0"
    const val koin = "2.1.5"

    const val material = "1.2.0"
    const val constraintLayout = "2.0.0"
    const val lifecycle = "2.2.0"
    const val viewPager = "1.1.0-alpha01"

    const val coroutines = "1.3.9"

    const val firebaseAnalytics = "18.0.2"
    const val firebaseCrashlytics = "17.3.1"
    const val firebasePerformance = "19.1.1"

    // Test
    const val jUnit = "4.12"
}

object Libraries {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.androidX}"

    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val viewPager = "androidx.viewpager2:viewpager2:${Versions.viewPager}"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val lifecycleCommon = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
    const val lifecycleProcess = "androidx.lifecycle:lifecycle-process:${Versions.lifecycle}"

    // DI
    const val koin = "org.koin:koin-core:${Versions.koin}"
    const val koinAndroid = "org.koin:koin-androidx-scope:${Versions.koin}"
    const val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"

    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    // FIREBASE
    const val firebaseAnalytics = "com.google.firebase:firebase-analytics:${Versions.firebaseAnalytics}"
    const val firebaseCrashlytics = "com.google.firebase:firebase-crashlytics:${Versions.firebaseCrashlytics}"
    const val firebasePerformance = "com.google.firebase:firebase-perf:${Versions.firebasePerformance}"
    // TESTS
    const val jUnit = "junit:junit:${Versions.jUnit}"
}