package com.example.fernandezhw4

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Nav(navController: NavHostController, modifier: Modifier) {

    NavHost(navController=navController, startDestination = "MainScreen", modifier) {
        composable(route="MainScreen") {
            MainScreen()
        }
        composable(route="AddScreen") {
            AddRestaurantScreen()
        }
        composable(route="SettingsScreen") {
            SettingsScreen()

        }
    }
}