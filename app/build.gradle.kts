import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

plugins {
    id(Plugin.ANDROID_APPLICATION)
    id(Plugin.KOTLIN_ANDROID)
    id(Plugin.GOOGLE_SERVICES)
    id(Plugin.CRASHLYTICS)
    id(Plugin.PERFORMANCE)
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
        multiDexEnabled = true
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

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(Libraries.kotlin)
    implementation(Libraries.appCompat)
    implementation(Libraries.material)
    implementation(Libraries.constraintLayout)
    implementation(Libraries.lifecycle)
    implementation(Libraries.lifecycleViewModel)
    implementation(Libraries.lifecycleCommon)
    implementation(Libraries.lifecycleCompiler)
    implementation(Libraries.lifecycleExtensions)
    implementation(Libraries.lifecycleLiveData)
    implementation(Libraries.lifecycleProcess)
    implementation(Libraries.lifecycleRuntime)
    implementation(Libraries.viewPager)

    // di
    implementation(Libraries.koin)
    implementation(Libraries.koinAndroid)
    implementation(Libraries.koinViewModel)

    // Coroutines
    implementation(Libraries.coroutinesCore)
    implementation(Libraries.coroutinesAndroid)

    // FIREBASE
    implementation(platform(Libraries.firebaseBom))
    implementation(Libraries.firebaseAnalytics)
    implementation(Libraries.firebaseCrashlytics)
    implementation(Libraries.firebasePerformance)

    // TESTS
    testImplementation(Libraries.jUnit)
}

project.ext.set("groupId", "ru.ladgertha")
project.ext.set("artifactId", "savingscalculator")
