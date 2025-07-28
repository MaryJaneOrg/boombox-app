package dev.gabrielsancho.boombox.screen

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import dev.gabrielsancho.boombox.component.BoomboxScaffold

class SettingsScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

        BoomboxScaffold(
            title = "SettingsScreen",
            actionLabel = "Go back",
            onAction = { navigator?.pop() }
        )
    }
}
