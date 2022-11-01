import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.aman.cryptotracker.ui.App
import androidx.compose.ui.Modifier

fun main() = application {

    val windowState = rememberWindowState()
    Window(
        onCloseRequest = ::exitApplication,
        state = windowState,
        title = "CryptoTrackker"
    ){
        Surface(modifier = Modifier.fillMaxSize()) {
            App()
        }
    }
}