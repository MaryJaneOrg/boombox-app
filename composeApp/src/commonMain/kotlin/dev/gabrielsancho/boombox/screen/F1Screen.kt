package dev.gabrielsancho.boombox.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import dev.gabrielsancho.boombox.resource.dto.CircuitDTO
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
    result: State<UiState<List<CircuitDTO>>?>,
    onMakeRequest: () -> Unit = {}
) {
    BoomboxScaffold(
        title = "F1 Circuits",
        actionLabel = "MakeRequest",
        onAction = onMakeRequest,
    ) {

        when (val uiState = result.value) {
            is UiState.Error -> Text(
                text = "Some Error Occurred: ${uiState.error?.message}"
            )

            is UiState.Loading -> Text(
                text = "Loading"
            )

            is UiState.Success -> Circuits(uiState.data.orEmpty())

            null -> Text(
                text = "Idle"
            )
        }
    }
}

@Composable
private fun Circuits(circuits: List<CircuitDTO>) {
    LazyColumn {
        items(circuits) { circuit ->
            Text(
                text = circuit.toString()
            )
        }
    }
}

@Composable
@Preview
private fun F1ScreenContentPreview() {
    F1ScreenContent(
        result = remember { mutableStateOf(UiState.Success(emptyList())) }
    )
}
