package dev.gabrielsancho.boombox.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import dev.gabrielsancho.boombox.component.BoomboxScaffold
import dev.gabrielsancho.boombox.model.ProfileModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.core.parameter.parametersOf

class ProfileScreen(
    val someParameter: String
) : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val screenModel = koinScreenModel<ProfileModel>(
            parameters = { parametersOf(someParameter) }
        )

        ProfileContent(
            counter = screenModel.counter.collectAsState(),
            screenName = screenModel.name.collectAsState(),
            onAction = { navigator?.pop() },
            onStartCounting = { screenModel.startCounting() },
            onSettings = { navigator?.push(SettingsScreen()) }
        )
    }
}

@Composable
private fun ProfileContent(
    counter: State<Int>,
    screenName: State<String>,
    onAction: () -> Unit = {},
    onStartCounting: () -> Unit = {},
    onSettings: () -> Unit = {}
) {
    BoomboxScaffold(
        title = "ProfileScreen (${screenName.value})",
        actionLabel = "Go back",
        onAction = onAction
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(
                space = 16.dp,
                alignment = Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Counter: ${counter.value}",
                color = Color.White
            )

            Button(onStartCounting) {
                Text("StartCounting")
            }

            Button(onSettings) {
                Text("Go to Settings")
            }
        }
    }
}

@Composable
@Preview
private fun ProfileContentPreview() {
    ProfileContent(
        counter = remember { mutableStateOf(1) },
        screenName = remember { mutableStateOf("Main") }
    )
}