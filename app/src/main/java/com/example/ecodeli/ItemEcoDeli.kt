package com.example.ecodeli

import java.io.Serializable

data class ItemEcoDeli(
    val id: String,
    val name: String,
    val destination: String,
    val status: String,
    val eta: String,
    val dateOrdered: String,
    val price: Double,
    val validationCode: String,
    val completed: Boolean
) : Serializable