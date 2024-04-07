plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = Environment.namespaces.refresh_header_material
    compileSdk = Environment.compileSdk

    defaultConfig {
        minSdk = Environment.minSdk

        testInstrumentationRunner = Environment.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        debug {
            buildConfigField("boolean", "isRelease", Environment.isRelease.toString())
        }
        release {
            buildConfigField("boolean", "isRelease", Environment.isRelease.toString())
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

    buildFeatures{
        dataBinding = true
        buildConfig = true
    }
}

dependencies {

    compileOnly(project(mapOf("path" to ":refresh-layout-kernel")))

    implementation(AndroidX.core)
    implementation(AndroidX.appcompat)
    implementation(AndroidX.constraintlayout)
    implementation(Google.material)

    testImplementation(AndroidX.junit.junit)
    androidTestImplementation(AndroidX.junit.testExt)
    androidTestImplementation(AndroidX.junit.testEspresso)

    implementation(ThirdParty.arouterApi)

    implementation(AndroidX.navigationFragment)
    implementation(AndroidX.navigationUI)
    implementation(AndroidX.navigationRuntime)

}