package dev.gabrielsancho.boombox

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import dev.gabrielsancho.boombox.config.ConfigureDI
import dev.gabrielsancho.boombox.config.ConfigureFirebase

fun main() {
    ConfigureDI()
    ConfigureFirebase()

    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "boombox",
        ) {
            Boombox()
        }
    }
}
