package dev.gabrielsancho.boombox

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import dev.gabrielsancho.boombox.setup.DependencyInjectionSetup

fun main() {
    DependencyInjectionSetup.start()

    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "boombox",
        ) {
            Boombox()
        }
    }
}
