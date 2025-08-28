package dev.gabrielsancho.boombox.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import boombox.composeapp.generated.resources.Res
import boombox.composeapp.generated.resources.email_label
import boombox.composeapp.generated.resources.login
import boombox.composeapp.generated.resources.password_label
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import dev.gabrielsancho.boombox.model.LoginModel
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

object LoginScreen : Screen {
    @Composable
    override fun Content() {
        val screenModel = koinScreenModel<LoginModel>()

        LoginContent(
            emailState = screenModel.email.collectAsState(),
            passwordState = screenModel.password.collectAsState(),
            onEmailChange = screenModel::onEmailChange,
            onPasswordChange = screenModel::onPasswordChange,
            onLoginClick = screenModel::onLoginClick
        )
    }
}

@Composable
private fun LoginContent(
    emailState: State<String>,
    passwordState: State<String>,
    loginState: State<Any?> = mutableStateOf(null),
    onEmailChange: (String) -> Unit = {},
    onPasswordChange: (String) -> Unit = {},
    onLoginClick: () -> Unit = {}
) {
    Scaffold {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(
                space = 16.dp,
                alignment = Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TextField(
                value = emailState.value,
                onValueChange = onEmailChange,
                label = { Text(stringResource(Res.string.email_label)) }
            )

            TextField(
                value = passwordState.value,
                onValueChange = onPasswordChange,
                label = { Text(stringResource(Res.string.password_label)) }
            )

            Button(
                onClick = onLoginClick
            ) { Text(stringResource(Res.string.login)) }

            Text(
                text = loginState.value.toString()
            )
        }
    }
}

@Composable
@Preview
private fun LoginContentPreview() {
    LoginContent(
        emailState = mutableStateOf(""),
        passwordState = mutableStateOf(""),
        onEmailChange = {},
        onPasswordChange = {},
        onLoginClick = {}
    )
}
