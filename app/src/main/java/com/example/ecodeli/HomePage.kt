package com.example.ecodeli

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextAlign
import com.example.ecodeli.ui.theme.GreenPrimary
import com.example.ecodeli.ui.theme.GreenAccent
import com.example.ecodeli.ui.theme.EarthSecondary
import androidx.compose.ui.draw.shadow

@Composable
fun HomePage(
    onSettingsClick: () -> Unit,
    onButton1Click: () -> Unit,
    onButton2Click: () -> Unit,
    onButton3Click: () -> Unit
) {
    Scaffold(
        // No topBar
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(GreenPrimary.copy(alpha = 0.10f), Color.Transparent),
                        startY = 0f,
                        endY = 600f
                    )
                )
                .padding(innerPadding)
        ) {
            IconButton(
                onClick = onSettingsClick,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 16.dp, end = 16.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.Settings,
                    contentDescription = "Settings",
                    tint = GreenPrimary
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
                    .padding(top = 72.dp)
                    .align(Alignment.TopCenter),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "EcoDeli",
                    style = MaterialTheme.typography.displayLarge,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(40.dp))
                EcoDeliActionButton(text = "My Deliveries", onClick = onButton1Click)
                EcoDeliActionButton(text = "My Orders", onClick = onButton2Click)
                EcoDeliActionButton(text = "Logout", onClick = onButton3Click, color = GreenAccent)
            }
        }
    }
}

@Composable
fun EcoDeliActionButton(text: String, onClick: () -> Unit, color: Color = GreenPrimary) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 14.dp)
            .shadow(4.dp, RoundedCornerShape(24.dp)),
        shape = RoundedCornerShape(24.dp),
        colors = ButtonDefaults.buttonColors(containerColor = color, contentColor = Color.White)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium.copy(color = Color.White)
        )
    }
}