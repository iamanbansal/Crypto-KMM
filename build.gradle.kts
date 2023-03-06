buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Dependencies.kotlinVersion}")
        classpath("com.android.tools.build:gradle:7.4.2")
        classpath(Dependencies.Build.serialzationPlugin)
        classpath(Dependencies.Build.sqlDelightPlugin)
        classpath("org.jetbrains.compose:compose-gradle-plugin:${Dependencies.Compose.composeDesktopVersion}")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")

    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}