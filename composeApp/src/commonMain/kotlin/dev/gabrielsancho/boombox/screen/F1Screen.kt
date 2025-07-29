package dev.gabrielsancho.boombox.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import dev.gabrielsancho.boombox.component.BoomboxScaffold
import dev.gabrielsancho.boombox.model.F1Model
import dev.gabrielsancho.boombox.model.domain.UiState
import org.jetbrains.compose.ui.tooling.preview.Preview

class F1Screen : Screen {
    @Composable
    override fun Content() {
        val screenModel = koinScreenModel<F1Model>()

        F1ScreenContent(
            result = screenModel.f1Circuits.collectAsState(),
            onMakeRequest = { screenModel.reload() }
        )
    }
}

@Composable
private fun F1ScreenContent(
    result: State<UiState<String>?>,
    onMakeRequest: () -> Unit = {}
) {
    BoomboxScaffold(
        title = "F1 Circuits",
        actionLabel = "MakeRequest",
        onAction = onMakeRequest,
    ) {
        Text(
            text = result.value.toString(),
            color = Color.White
        )
    }
}

@Composable
@Preview
private fun F1ScreenContentPreview() {
    F1ScreenContent(
        result = remember { mutableStateOf(UiState.Success("Circuits")) }
    )
}
