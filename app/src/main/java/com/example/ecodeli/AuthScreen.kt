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

@Composable
fun AuthScreen(
    onSignInClick: () -> Unit,
    onSignUpClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(32.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Welcome",
                style = MaterialTheme.typography.headlineSmall,
                color = GreenPrimary,
                modifier = Modifier.padding(bottom = 32.dp)
            )
            Button(
                onClick = onSignInClick,
                colors = ButtonDefaults.buttonColors(containerColor = GreenPrimary),
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Text("Sign In", color = Color.White)
            }
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = onSignUpClick,
                colors = ButtonDefaults.buttonColors(containerColor = GreenPrimary),
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Text("Sign Up", color = Color.White)
            }
        }
    }
} 