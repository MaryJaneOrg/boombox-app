package dev.gabrielsancho.boombox.model.domain

import kotlinx.coroutines.flow.*

/**
 * Creates a Flow that emits a UiState<T> based on the result of the provided suspend function.
 * It starts with a Loading state, emits the result as Success, or catches any error and emits it as Error.
 *
 * @param fetch A suspend function that fetches the data of type T.
 * @return A Flow emitting UiState<T>.
 */
fun <T> uiStateFlowOf(fetch: suspend () -> T): Flow<UiState<T>> =
    flow { emit(fetch()) }
        .map { UiState(it) }
        .onStart { emit(UiState.Loading()) }
        .catch { emit(UiState.Error(it)) }
