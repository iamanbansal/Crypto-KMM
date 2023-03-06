object Dependencies {

    const val kotlinVersion = "1.7.20"

    object  Build {
        const val serialzationPlugin = "org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion"
        const val sqlDelightPlugin = "com.squareup.sqldelight:gradle-plugin:${SQLDelight.sqlDelightVersion}"
    }

    object Plugins{
        const val serialization = "plugin.serialization"
        const val sqlDelight = "com.squareup.sqldelight"
    }
    object Ktor {
        private const val ktorVersion = "2.2.3"
        const val core = "io.ktor:ktor-client-core:${ktorVersion}"
        const val clientSerialization = "io.ktor:ktor-client-serialization:${ktorVersion}"
        const val androidClient = "io.ktor:ktor-client-android:${ktorVersion}"
        const val logging = "io.ktor:ktor-client-logging:${ktorVersion}"
        const val iosClient = "io.ktor:ktor-client-ios:${ktorVersion}"
        const val javaClient = "io.ktor:ktor-client-java:$ktorVersion"
        const val contentNegotiation = "io.ktor:ktor-client-content-negotiation:$ktorVersion"
        const val serialization = "io.ktor:ktor-serialization-kotlinx-json:$ktorVersion"
    }

    object Coroutines{
        const val coroutineVersion = "1.6.4"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutineVersion"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion"
    }

    object SQLDelight {
        const val sqlDelightVersion = "1.5.5"
        const val runtime = "com.squareup.sqldelight:runtime:${sqlDelightVersion}"
        const val androidDriver = "com.squareup.sqldelight:android-driver:${sqlDelightVersion}"
        const val nativeDriver = "com.squareup.sqldelight:native-driver:${sqlDelightVersion}"
    }

    object Kotlinx {
        private const val kotlinxDatetimeVersion = "0.1.1"
        const val datetime = "org.jetbrains.kotlinx:kotlinx-datetime:${kotlinxDatetimeVersion}"
    }

    object Compose {
        const val composeVersion = "1.3.0"
        const val composeDesktopVersion = "1.3.0"
        const val kotlinCompilerVersion = "1.5.10"

        const val runtime = "androidx.compose.runtime:runtime:${composeVersion}"
        const val runtimeLiveData = "androidx.compose.runtime:runtime-livedata:${composeVersion}"
        const val ui = "androidx.compose.ui:ui:${composeVersion}"
        const val material = "androidx.compose.material:material:${composeVersion}"
        const val materialIcon = "androidx.compose.material:material-icons-core:${composeVersion}"
        const val uiTooling = "androidx.compose.ui:ui-tooling:${composeVersion}"
        const val foundation = "androidx.compose.foundation:foundation:${composeVersion}"
        const val compiler = "androidx.compose.compiler:compiler:${composeVersion}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout-compose:.0.0-alpha03"
        const val activity = "androidx.activity:activity-compose:1.3.0-alpha08"
        const val navigation = "androidx.navigation:navigation-compose:1.0.0-alpha10"
    }
}