buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Dependencies.kotlinVersion}")
        classpath("com.android.tools.build:gradle:4.2.1")
        classpath(Dependencies.Build.serialzationPlugin)
        classpath(Dependencies.Build.sqlDelightPlugin)
    }
}

allprojects {
    repositories {
        jcenter()
        google()
        mavenCentral()
        maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}