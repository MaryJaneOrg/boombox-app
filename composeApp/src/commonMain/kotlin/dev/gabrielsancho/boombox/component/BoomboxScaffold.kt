package dev.gabrielsancho.boombox.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun BoomboxScaffold(
    title: String,
    actionLabel: String,
    onAction: () -> Unit,
    content: @Composable () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(
            space = 16.dp,
            alignment = Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            color = Color.White,
            text = title
        )

        Box(
            modifier = Modifier.weight(1f),
            content = { content() }
        )

        Button(onAction) {
            Text(actionLabel)
        }
    }
}

@Composable
@Preview
private fun BoomboxScaffoldPreview() {
    BoomboxScaffold(
        title = "Hello, world",
        actionLabel = "Go to somewhere",
        onAction = { println("Go to somewhere") }
    )
}
