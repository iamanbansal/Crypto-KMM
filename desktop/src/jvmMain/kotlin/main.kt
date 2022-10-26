import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.aman.cryptotracker.ui.App

fun main() = application {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        App()
    }
}