object PluginVersion {
    const val kotlin = "1.3.61"
    const val gradle = "3.5.2"
}

object Plugin {
    const val ANDROID_APPLICATION = "com.android.application"
    const val ANDROID_LIBRARY = "com.android.library"
    const val KOTLIN_ANDROID = "org.jetbrains.kotlin.android"
    const val KOTLIN_ANDROID_EXTENSIONS = "org.jetbrains.kotlin.android.extensions"
    const val KOTLIN_KAPT = "org.jetbrains.kotlin.kapt"
    const val JAVA_LIBRARY = "java-library"
    const val KOTLIN_JVM = "org.jetbrains.kotlin.jvm"
}

object ClassPath {
    const val gradle = "com.android.tools.build:gradle:${PluginVersion.gradle}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${PluginVersion.kotlin}"
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

    // DI
    const val koin = "org.koin:koin-core:${Versions.koin}"
    const val koinAndroid = "org.koin:koin-androidx-scope:${Versions.koin}"
    const val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"

    // TESTS
    const val jUnit = "junit:junit:${Versions.jUnit}"
}