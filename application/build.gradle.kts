import app.appDependencies

plugins {
    id("com.android.application")
    id("com.google.dagger.hilt.android")
    id("org.jetbrains.kotlin.android")
    id("com.google.firebase.crashlytics")
    id("com.google.firebase.appdistribution")
    kotlin("kapt")
}

android {
    namespace = namespace("app")
    compileSdk = App.compileSdk

    defaultConfig {
        applicationId = App.namespace
        minSdk = App.minSdk
        targetSdk = App.targetSdk
        versionCode = App.appVersionCode(gradle)
        versionName = App.versionName

        testInstrumentationRunner = App.testInstrumentationRunner
    }
    buildTypes {
        val appName = "TEST MANDIRI"
        debug {
            isDebuggable = true
            isMinifyEnabled = false
            isShrinkResources = false
            applicationIdSuffix = ".dev"
            signingConfig = signingConfigs.getByName("debug")
            resValue("string", "app_name", "$appName - DEV")
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro"
            )
        }

    }
    compileOptions {
        sourceCompatibility = App.javaVersion
        targetCompatibility = App.javaVersion
    }
    buildFeatures{
        dataBinding = true
        viewBinding = true
    }
    kotlinOptions {
        jvmTarget = App.jvmTarget
    }
}

dependencies {
    appDependencies()
    api(project(":module"))
    api(project(":application:domain"))
    api(project(":application:view"))

}
