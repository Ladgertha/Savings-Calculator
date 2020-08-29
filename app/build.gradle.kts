import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

plugins {
    id(Plugin.ANDROID_APPLICATION)
    id(Plugin.KOTLIN_ANDROID)
    id(Plugin.KOTLIN_ANDROID_EXTENSIONS)
}

android {
    compileSdkVersion(AppData.compileSdkVersion)

    defaultConfig {
        applicationId = AppData.applicationId
        minSdkVersion(AppData.minSdkVersion)
        targetSdkVersion(AppData.targetSdkVersion)
        buildToolsVersion(AppData.buildToolsVersion)

        versionCode = AppData.versionCode
        versionName = AppData.versionName

        testInstrumentationRunner = AppData.testInstrumentationRunner
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        val options = this as? KotlinJvmOptions
        options?.jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    implementation(Libraries.kotlin)
    implementation(Libraries.appCompat)
    implementation(Libraries.material)
    implementation(Libraries.constraintLayout)
    implementation(Libraries.lifecycle)

    // di
    implementation(Libraries.koin)
    implementation(Libraries.koinAndroid)
    implementation(Libraries.koinViewModel)

    // TESTS
    testImplementation(Libraries.jUnit)
}

project.ext.set("groupId", "ru.ladgertha")
project.ext.set("artifactId", "savingscalculator")
