package dev.gabrielsancho.boombox.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import dev.gabrielsancho.boombox.component.BoomboxScaffold

class HomeScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val someCode = remember { "Created on HomeScreen" }

        BoomboxScaffold(
            title = "HomeScreen",
            actionLabel = "Go to profile",
            onAction = {
                navigator?.push(ProfileScreen(someCode))
            }
        )
    }
}
