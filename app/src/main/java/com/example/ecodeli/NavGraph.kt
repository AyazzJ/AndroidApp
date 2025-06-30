package com.example.ecodeli

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ecodeli.AuthScreen
import com.example.ecodeli.SignUpScreen
import com.example.ecodeli.SignUpSuccessScreen
import com.example.ecodeli.ErrorScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "loading"
    ) {
        composable("loading") {
            LoadingScreen(
                onFinished = {
                    navController.navigate("auth") {
                        popUpTo("loading") { inclusive = true }
                    }
                }
            )
        }

        composable("auth") {
            AuthScreen(
                onSignInClick = {
                    navController.navigate("login") {
                        popUpTo("auth") { inclusive = true }
                    }
                },
                onSignUpClick = {
                    navController.navigate("signup") {
                        popUpTo("auth") { inclusive = true }
                    }
                }
            )
        }

        composable("login") {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate("home") {
                        popUpTo("login") { inclusive = true }
                    }
                },
                onBackClick = {
                    navController.navigate("auth") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            )
        }

        composable("home") {
            HomePage(
                onSettingsClick = { navController.navigate("settings") },
                onButton1Click = { navController.navigate("deliveries") },
                onButton2Click = { navController.navigate("orders") },
                onButton3Click = { navController.navigate("login")}
            )
        }

        composable("settings"){
            SettingsScreen(
                userName = "Ayaz Jubaer",
                userEmail = "ajubaer@myges.fr",
                userPlan = "premium",
                onBackClick = {
                    navController.popBackStack()
                },
                onLogoutClick = {
                    // Example: return to login screen on logout
                    navController.navigate("login") {
                        popUpTo("home") { inclusive = true }
                    }
                }
            )
        }

        composable("orders") {
            val orders = remember {
                listOf(
                    ItemEcoDeli("1", "Eco Bag", "123 Green St", "Shipped", "2 days", "2025-06-18", 12.99, "ABC123", false),
                    ItemEcoDeli("2", "Reusable Bottle", "456 Blue Ave", "Processing", "3 days", "2025-06-17", 19.50, "XYZ456", true),
                    ItemEcoDeli("3", "Bamboo Straw", "789 Earth Rd", "Delivered", "0 days", "2025-06-15", 4.99, "LMN789", false)
                )
            }

            OrdersScreen(
                orders = orders,
                onBackClick = { navController.popBackStack() },
                onOrderClick = { selectedOrder ->
                    navController.currentBackStackEntry
                        ?.savedStateHandle
                        ?.set("selectedOrder", selectedOrder)
                    navController.navigate("orderDetail")
                }
            )
        }


        composable("orderDetail") {
            val order = navController
                .previousBackStackEntry
                ?.savedStateHandle
                ?.get<ItemEcoDeli>("selectedOrder")

            if (order != null) {
                OrderDetailScreen(
                    order = order,
                    onBackClick = { navController.popBackStack() }
                )
            } else {
                // Fallback if something goes wrong
                Text("Error: Order not found")
            }
        }

        composable("deliveries") {
            val deliveries = remember {
                listOf(
                    ItemEcoDeli("4", "Compost Bin", "10 Garden Way", "Out for Delivery", "Today", "2025-06-20", 25.99, "1234", false),
                    ItemEcoDeli("5", "Solar Charger", "99 Sun Lane", "In Transit", "Tomorrow", "2025-06-19", 45.00, "5678", true)
                )
            }

            DeliveriesScreen(
                deliveries = deliveries,
                onBackClick = { navController.popBackStack() },
                onDeliveryClick = { selectedDelivery ->
                    navController.currentBackStackEntry
                        ?.savedStateHandle
                        ?.set("selectedDelivery", selectedDelivery)
                    navController.navigate("deliveryDetail")
                }
            )
        }

        composable("deliveryDetail") {
            val delivery = navController
                .previousBackStackEntry
                ?.savedStateHandle
                ?.get<ItemEcoDeli>("selectedDelivery")

            if (delivery != null) {
                DeliveryDetailScreen(
                    delivery = delivery,
                    onBackClick = { navController.popBackStack() }
                )
            } else {
                Text("Error: Delivery not found")
            }
        }

        composable("signup") {
            SignUpScreen(
                onSignUpSuccess = {
                    navController.navigate("signup_success") {
                        popUpTo("signup") { inclusive = true }
                    }
                },
                onSignUpError = {
                    navController.navigate("signup_error") {
                        popUpTo("signup") { inclusive = true }
                    }
                },
                onBackClick = {
                    navController.navigate("auth") {
                        popUpTo("signup") { inclusive = true }
                    }
                }
            )
        }

        composable("signup_success") {
            SignUpSuccessScreen(
                onContinue = {
                    navController.navigate("login") {
                        popUpTo("signup_success") { inclusive = true }
                    }
                }
            )
        }

        composable("signup_error") {
            ErrorScreen(
                message = "All fields are required.",
                onBack = {
                    navController.navigate("signup") {
                        popUpTo("signup_error") { inclusive = true }
                    }
                }
            )
        }
    }
}