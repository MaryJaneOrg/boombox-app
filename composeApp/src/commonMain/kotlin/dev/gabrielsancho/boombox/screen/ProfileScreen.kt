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
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import dev.gabrielsancho.boombox.component.BoomboxScaffold
import dev.gabrielsancho.boombox.model.HomeModel
import org.jetbrains.compose.ui.tooling.preview.Preview

class ProfileScreen(
    val someParameter: String = "Default value"
) : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val screenModel = rememberScreenModel { HomeModel() }


        Content(
            countingState = screenModel.counter.collectAsState(),
            screenName = screenModel.name.value,
            onAction = { navigator?.pop() },
            onStartCounting = { screenModel.startCounting() }
        )
    }

    @Composable
    private fun Content(
        countingState: State<Int>,
        screenName: String,
        onAction: () -> Unit,
        onStartCounting: () -> Unit
    ) {
        BoomboxScaffold(
            title = "ProfileScreen ($screenName)",
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
                    text = someParameter,
                    color = Color.White
                )
                Text(
                    text = "Counter: ${countingState.value}",
                    color = Color.White
                )
                Button(onStartCounting) {
                    Text("StartCounting")
                }
            }
        }
    }

    @Composable
    @Preview
    private fun ComposablePreview() {
        Content(
            countingState = remember { mutableStateOf(1) },
            screenName = "Main",
            onAction = {},
            onStartCounting = {}
        )
    }
}