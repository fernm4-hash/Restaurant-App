package com.example.fernandezhw4

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme

import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@OptIn( ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(navController: NavController) {
    var showMenu by remember { mutableStateOf(false) }
    CenterAlignedTopAppBar (
        title = { Text(text = "Restaurant App") },
        actions = {
            IconButton(onClick = { showMenu = !showMenu }) {
                Icon(Icons.Default.MoreVert, contentDescription = null)
            }
            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false }
            ) {
                DropdownMenuItem(
                    text= { Text("Settings") },
                    onClick = {
                        navController.navigate("SettingsScreen"){
                            launchSingleTop = true
                        }

                        showMenu = false
                    },
                    leadingIcon = { Icon(Icons.Filled.Settings, contentDescription = null) })
            } // end - DropdownMenu
        } // end - actions
    )
}