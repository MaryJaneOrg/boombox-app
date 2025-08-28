package dev.gabrielsancho.boombox.model

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import dev.gabrielsancho.boombox.api.platform.getPlatform
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginModel : ScreenModel {
    private val _email = MutableStateFlow("gabriel.sancho13@gmail.com")
    val email = _email.asStateFlow()

    private val _password = MutableStateFlow("123456")
    val password = _password.asStateFlow()
//
//    val status = Firebase
//        .auth
//        .authStateChanged
//        .stateIn(screenModelScope, SharingStarted.Lazily, null)

    fun onEmailChange(newEmail: String) {
        _email.update { newEmail }
    }

    fun onPasswordChange(newPassword: String) {
        _password.update { newPassword }
    }

    fun onLoginClick() {
        screenModelScope.launch {
//            Firebase.auth.signInWithEmailAndPassword(
//                email = _email.value,
//                password = _password.value
//            )
        }

        getPlatform().openUrl("https://boombox.gabrielsancho.dev")
    }
}
