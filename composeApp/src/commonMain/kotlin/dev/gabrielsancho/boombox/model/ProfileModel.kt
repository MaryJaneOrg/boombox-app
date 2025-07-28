package dev.gabrielsancho.boombox.model

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import dev.gabrielsancho.boombox.usecase.GetPlatformNameUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

class ProfileModel(
    private val getPlatformNameUseCase: GetPlatformNameUseCase,
    someParameter: String
) : ScreenModel {
    private val _name = MutableStateFlow(someParameter)
    val name = _name.asStateFlow()

    private val _counter = MutableStateFlow(0)
    val counter = _counter.asStateFlow()

    fun startCounting() {
        _name.update { getPlatformNameUseCase() }

        screenModelScope.launch(Dispatchers.Default) {
            while (true) {
                delay(1.seconds)
                _counter.update { it + 1 }
            }
        }
    }
}
