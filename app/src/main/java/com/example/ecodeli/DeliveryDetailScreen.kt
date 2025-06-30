package com.example.ecodeli

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.asPaddingValues

@Composable
fun DeliveryDetailScreen(
    delivery: ItemEcoDeli,
    onBackClick: () -> Unit
) {
    var inputCode by remember { mutableStateOf("") }
    var confirmed by remember { mutableStateOf(false) }

    val isCorrect = inputCode == delivery.validationCode

    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(WindowInsets.statusBars.asPaddingValues())
                    .padding(horizontal = 8.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = onBackClick,
                    modifier = Modifier.size(36.dp)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Delivery Details",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier,
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(24.dp)
        ) {
            Text("ID: ${delivery.id}")
            Text("Destination: ${delivery.destination}")
            Text("Status: ${delivery.status}")
            Text("ETA: ${delivery.eta}")
            Text("Completed: ${if (confirmed) "Yes" else "No"}")

            Spacer(modifier = Modifier.height(24.dp))

            OutlinedTextField(
                value = inputCode,
                onValueChange = { if (it.length <= 4) inputCode = it },
                label = { Text("Enter 4-digit validation code") },
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { confirmed = isCorrect },
                enabled = inputCode.length == 4
            ) {
                Text("Confirm Delivery")
            }

            if (inputCode.isNotEmpty() && !isCorrect) {
                Text("Invalid code", color = MaterialTheme.colorScheme.error)
            }

            if (confirmed && isCorrect) {
                Text("Delivery Confirmed!", color = MaterialTheme.colorScheme.primary)
            }
        }
    }
}