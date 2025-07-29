package dev.gabrielsancho.boombox.model.domain

sealed interface UiState<T> {
    class Loading<T> : UiState<T>
    data class Error<T>(val error: Throwable?) : UiState<T>
    data class Success<T>(val data: T?) : UiState<T>
}
