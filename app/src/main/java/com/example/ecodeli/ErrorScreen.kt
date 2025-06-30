package com.example.ecodeli

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.background
import com.example.ecodeli.ui.theme.GreenPrimary
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.BorderStroke

@Composable
fun ErrorScreen(message: String, onBack: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(32.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(message, color = MaterialTheme.colorScheme.error, modifier = Modifier.padding(bottom = 32.dp))
            Button(
                onClick = onBack,
                colors = ButtonDefaults.buttonColors(containerColor = GreenPrimary),
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.fillMaxWidth(0.7f),
                border = BorderStroke(1.dp, GreenPrimary)
            ) {
                Text("Back", color = Color.White)
            }
        }
    }
} 