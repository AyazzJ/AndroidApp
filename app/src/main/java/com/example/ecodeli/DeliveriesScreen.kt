package com.example.ecodeli

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.asPaddingValues

@Composable
fun DeliveriesScreen(
    deliveries: List<ItemEcoDeli>,
    onBackClick: () -> Unit,
    onDeliveryClick: (ItemEcoDeli) -> Unit
) {
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
                    text = "Deliveries",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier,
                )
            }
        }
    ) { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(deliveries) { delivery ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .clickable { onDeliveryClick(delivery) }
                ) {
                    Column(Modifier.padding(16.dp)) {
                        Text("ID: ${delivery.id}", style = MaterialTheme.typography.titleMedium)
                        Text("Destination: ${delivery.destination}", style = MaterialTheme.typography.bodyMedium)
                        Text("ETA: ${delivery.eta}", style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }
    }
}