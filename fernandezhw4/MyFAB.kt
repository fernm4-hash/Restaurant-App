package com.example.fernandezhw4

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun MyFAB(navController: NavController) {
    FloatingActionButton(
        onClick = {
            navController.navigate("AddScreen"){
                launchSingleTop = true
            }


        },
    ) {
        Icon(Icons.Filled.Add, "Floating action button.")
    }
}