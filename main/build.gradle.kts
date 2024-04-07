plugins {
    if (Environment.isRelease) {
        id("com.android.library")
    } else {
        id("com.android.application")
    }
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = Environment.namespaces.main
    compileSdk = Environment.compileSdk

    defaultConfig {
        minSdk = Environment.minSdk

        if (!Environment.isRelease) {
            applicationId = Environment.AppId.main
            targetSdk = Environment.targetSdk
            versionCode = Environment.versionCode
            versionName = Environment.versionName
        }

        testInstrumentationRunner = Environment.testInstrumentationRunner

        kapt {
            arguments {
                arg(Environment.AROUTER_MODULE_NAME, project.name)
            }
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    sourceSets {
        getByName("main") {
            if (Environment.isRelease) {
                manifest.srcFile(Environment.manifestReleasePath)
            } else {
                manifest.srcFile(Environment.manifestDebugPath)
            }
        }
    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    implementation(project(mapOf("path" to ":base")))

    implementation(project(mapOf("path" to ":refresh-footer")))
    implementation(project(mapOf("path" to ":refresh-header")))
    implementation(project(mapOf("path" to ":refresh-layout")))

    implementation(project(mapOf("path" to ":refresh-drawable-path")))
    implementation(project(mapOf("path" to ":refresh-layout-kernel")))
    implementation(project(mapOf("path" to ":refresh-header-classics")))
    implementation(project(mapOf("path" to ":refresh-header-radar")))
    implementation(project(mapOf("path" to ":refresh-header-falsify")))
    implementation(project(mapOf("path" to ":refresh-header-material")))
    implementation(project(mapOf("path" to ":refresh-header-two-level")))
    implementation(project(mapOf("path" to ":refresh-footer-ball")))

    implementation(AndroidX.core)
    implementation(AndroidX.appcompat)
    implementation(AndroidX.constraintlayout)

    implementation(AndroidX.navigationFragment)
    implementation(AndroidX.navigationUI)
    implementation(AndroidX.navigationRuntime)

    implementation(Google.material)

    testImplementation(AndroidX.junit.junit)
    androidTestImplementation(AndroidX.junit.testExt)
    androidTestImplementation(AndroidX.junit.testEspresso)

    implementation(ThirdParty.arouterApi)
    kapt(ThirdParty.arouterCompiler)

    implementation(ThirdParty.lottie)

    implementation ("com.github.czy1121:loadinglayout:1.0.1")

    implementation(ThirdParty.bannerViewPager)
}