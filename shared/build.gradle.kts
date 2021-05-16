import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    kotlin(Dependencies.Plugins.serialization)
    id(Dependencies.Plugins.sqlDelight)
}

version = "1.0"

kotlin {
    android()

    val iosTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget =
        if (System.getenv("SDK_NAME")?.startsWith("iphoneos") == true)
            ::iosArm64
        else
            ::iosX64

    iosTarget("ios") {}

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        frameworkName = "shared"
        podfile = project.file("../iosApp/Podfile")
    }


    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Dependencies.KtorVersion.core)
                implementation(Dependencies.KtorVersion.clientSerialization)
                implementation(Dependencies.SQLDelight.runtime)
                implementation(Dependencies.Kotlinx.serialization)

            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Dependencies.KtorVersion.android)
                implementation(Dependencies.SQLDelight.androidDriver)
            }
        }

        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13.2")
            }
        }


        val iosMain by getting {
            dependencies {
                implementation(Dependencies.KtorVersion.ios)
                implementation(Dependencies.SQLDelight.nativeDriver)
            }
        }
        val iosTest by getting
    }
}

android {
    compileSdkVersion(30)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(30)
    }
}

sqldelight {
    database(name = "CryptoDatabase") { // This will be the name of the generated database class.
        packageName = "database"
    }
}