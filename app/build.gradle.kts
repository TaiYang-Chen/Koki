plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = Environment.namespaces.app
    compileSdk = Environment.compileSdk

    defaultConfig {
        applicationId = Environment.AppId.applicationId
        minSdk = Environment.minSdk
        targetSdk = Environment.targetSdk
        versionCode = Environment.versionCode
        versionName = Environment.versionName

        testInstrumentationRunner = Environment.testInstrumentationRunner

        kapt {
            arguments {
                arg("AROUTER_MODULE_NAME", project.getName())
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
            manifest.srcFile("src/main/AndroidManifest.xml")
        }
    }

    buildFeatures{
        dataBinding = true
    }
}

dependencies {
    implementation(AndroidX.core)
    implementation(AndroidX.appcompat)
    implementation(AndroidX.constraintlayout)
    implementation(Google.material)

    testImplementation(AndroidX.junit.junit)
    androidTestImplementation(AndroidX.junit.testExt)
    androidTestImplementation(AndroidX.junit.testEspresso)

    implementation(ThirdParty.mmkv)
    implementation(ThirdParty.bannerViewPager)

    implementation(ThirdParty.arouterApi)
    kapt(ThirdParty.arouterCompiler)

    implementation(project(mapOf("path" to ":base")))
    //依附app壳
    if (!Environment.isRelease) {
        implementation(project(mapOf("path" to ":login")))
        implementation(project(mapOf("path" to ":main")))
    }
}