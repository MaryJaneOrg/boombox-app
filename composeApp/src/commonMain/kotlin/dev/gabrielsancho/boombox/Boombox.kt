package dev.gabrielsancho.boombox

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import dev.gabrielsancho.boombox.screen.LoginScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun Boombox() {
    MaterialTheme {
        Navigator(screen = LoginScreen)
    }
}
