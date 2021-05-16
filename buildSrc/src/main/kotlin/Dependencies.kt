object Dependencies {

    const val kotlinVersion = "1.5.0"

    object  Build {
        const val serialzationPlugin = "org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion"
        const val sqlDelightPlugin = "com.squareup.sqldelight:gradle-plugin:$kotlinVersion"
    }

    object Plugins{
        const val serialization = "plugin.serialization"
        const val sqlDelight = "com.squareup.sqldelight"
    }
    object KtorVersion {
        private const val ktorVersion = "1.5.4"
        const val core = "io.ktor:ktor-client-core:${ktorVersion}"
        const val clientSerialization = "io.ktor:ktor-client-serialization:${ktorVersion}"
        const val android = "io.ktor:ktor-client-android:${ktorVersion}"
        const val ios = "io.ktor:ktor-client-ios:${ktorVersion}"
    }


    object SQLDelight {
        private const val sqlDelightVersion = "1.4.3"
        const val runtime = "com.squareup.sqldelight:runtime:${sqlDelightVersion}"
        const val androidDriver = "com.squareup.sqldelight:android-driver:${sqlDelightVersion}"
        const val nativeDriver = "com.squareup.sqldelight:native-driver:${sqlDelightVersion}"
    }

    object Kotlinx {
        private const val kotlinxDatetimeVersion = "0.1.1"
        const val datetime = "org.jetbrains.kotlinx:kotlinx-datetime:${kotlinxDatetimeVersion}"
        const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.1"
    }

    object Compose {
        private const val composeVersion = "1.0.0-beta05"
        const val runtime = "androidx.compose.runtime:runtime:${composeVersion}"
        const val runtimeLiveData = "androidx.compose.runtime:runtime-livedata:${composeVersion}"
        const val ui = "androidx.compose.ui:ui:${composeVersion}"
        const val material = "androidx.compose.material:material:${composeVersion}"
        const val uiTooling = "androidx.compose.ui:ui-tooling:${composeVersion}"
        const val foundation = "androidx.compose.foundation:foundation:${composeVersion}"
        const val compiler = "androidx.compose.compiler:compiler:${composeVersion}"

        private const val constraintLayoutComposeVersion = "1.0.0-alpha03"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout-compose:${constraintLayoutComposeVersion}"

        private const val composeActivitiesVersion = "1.3.0-alpha03"
        const val activity = "androidx.activity:activity-compose:${composeActivitiesVersion}"

        private const val composeNavigationVerson = "1.0.0-alpha10"
        const val navigation = "androidx.navigation:navigation-compose:${composeNavigationVerson}"
    }
}