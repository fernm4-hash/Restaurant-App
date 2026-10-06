package com.example.fernandezhw4

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DefaultText(text: String) {
    Text(
        modifier = Modifier.padding(5.dp),
        text = text,
        color = Color.Magenta,
        style = MaterialTheme.typography.bodyLarge
    )
}