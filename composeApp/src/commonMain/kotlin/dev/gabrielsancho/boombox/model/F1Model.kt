package dev.gabrielsancho.boombox.model

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import dev.gabrielsancho.boombox.model.domain.UiState
import dev.gabrielsancho.boombox.usecase.GetF1CircuitsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*

@OptIn(ExperimentalCoroutinesApi::class)
class F1Model(
    private val getF1CircuitsUseCase: GetF1CircuitsUseCase
) : ScreenModel {
    private val refreshTrigger = Channel<Unit>(capacity = Channel.CONFLATED)

    val f1Circuits: StateFlow<UiState<String>?> = flow {
        for (trigger in refreshTrigger) {
            emit(trigger)
        }
    }
        .flatMapLatest {
            flow { emit(getF1CircuitsUseCase()) }
                .map { UiState.Success(it) as UiState<String> }
                .onStart { emit(UiState.Loading()) }
        }
        .catch { emit(UiState.Error(it)) }
        .flowOn(Dispatchers.Default)
        .stateIn(screenModelScope, SharingStarted.Lazily, null)

    fun reload() {
        refreshTrigger.trySend(Unit)
    }
}
