package dev.gabrielsancho.boombox.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import coil3.compose.AsyncImage
import dev.gabrielsancho.boombox.component.BoomboxScaffold
import dev.gabrielsancho.boombox.model.F1Model
import dev.gabrielsancho.boombox.model.domain.UiState
import dev.gabrielsancho.boombox.resource.dto.CircuitDTO
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
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(circuits) { circuit ->
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .border(
                        color = Color.White,
                        width = 1.dp,
                        shape = RoundedCornerShape(4.dp)
                    )
                    .padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = circuit.name ?: "Unknown Circuit",
                    color = Color.White
                )

                AsyncImage(
                    modifier = Modifier.fillMaxWidth(),
                    model = circuit.image,
                    contentDescription = circuit.name
                )
            }
        }
    }
}

@Composable
@Preview
private fun F1ScreenContentPreview() {
    val result = remember {
        mutableStateOf(
            UiState.Success(
                listOf(
                    CircuitDTO(
                        id = 6703,
                        name = "Normand Acevedo",
                        image = "https://media.api-sports.io/formula-1/circuits/1.png",
                        competition = null,
                        firstGrandPrix = 3298,
                        laps = 2238,
                        length = "detracto",
                        raceDistance = "enim",
                        lapRecord = null,
                        capacity = 7017,
                        opened = 5240,
                        owner = "civibus"
                    ),
                    CircuitDTO(
                        id = 6703,
                        name = "Normand Acevedo",
                        image = "https://media.api-sports.io/formula-1/circuits/2.png",
                        competition = null,
                        firstGrandPrix = 3298,
                        laps = 2238,
                        length = "detracto",
                        raceDistance = "enim",
                        lapRecord = null,
                        capacity = 7017,
                        opened = 5240,
                        owner = "civibus"

                    )
                )
            )
        )
    }


    F1ScreenContent(
        result = result
    )
}
