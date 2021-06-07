plugins {
    id("com.android.application")
    kotlin("android")
    id("org.jetbrains.compose")
}

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.aman.cryptotracker"
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
        }
    }

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs += "-Xallow-jvm-ir-dependencies"
        useIR = true

    }

    composeOptions {
        kotlinCompilerVersion = Dependencies.Compose.kotlinCompilerVersion
//        kotlinCompilerExtensionVersion = Dependencies.Compose.composeVersion
    }

}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")

    implementation(Dependencies.Compose.ui)
    // Tooling support (Previews, etc.)
    implementation(Dependencies.Compose.uiTooling)
    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation(Dependencies.Compose.foundation)
    // Material Design
    implementation(Dependencies.Compose.material)
    // Material design icons
    implementation(Dependencies.Compose.materialIcon)
    // Integration with observables
    implementation(Dependencies.Compose.runtimeLiveData)
    //Compose Activity
    implementation(Dependencies.Compose.activity)

}