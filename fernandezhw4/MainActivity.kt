package com.example.fernandezhw4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.fernandezhw4.ui.theme.FernandezHW4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FernandezHW4Theme {

                val navItemsList = listOf(
                    MyNavItem(
                        title="Restaurant",
                        iconSelected = Icons.Filled.Home,
                        iconUnselected = Icons.Outlined.Home,
                        route="MainScreen"
                    ),
                    MyNavItem(title="Add Restaurants",
                        iconSelected = Icons.Filled.Add,
                        iconUnselected = Icons.Outlined.Add,
                        route="AddScreen"
                    ),
                )

                var selectedItemIndex by rememberSaveable { mutableStateOf(0) }
                val navHostController = rememberNavController()
                val navBackStackEntry by navHostController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination


                Scaffold(
                    topBar = { TopAppBar(navHostController) },
                    bottomBar = {
                        NavigationBar {
                            navItemsList.forEachIndexed { index, item ->
                                NavigationBarItem(
                                    selected = currentDestination?.hierarchy?.any { it.route.equals(item.route) } == true,
                                    onClick = {
                                        selectedItemIndex = index
                                        navHostController.navigate(item.route) {
                                            launchSingleTop = true
                                            restoreState = true
                                            popUpTo(navHostController.graph.findStartDestination().id) { saveState = true }
                                        }
                                    },
                                    label = { Text(text = item.title) },
                                    icon = { Icon(contentDescription = item.title,
                                        imageVector = if (index == selectedItemIndex) item.iconSelected
                                        else item.iconUnselected
                                    )
                                    }
                                ) // end – NavigationBarItem
                            } // end – forEachIndexed
                        } // end - NavigationBar
                    },
                    floatingActionButton = { MyFAB(navHostController) },
                    modifier = Modifier.fillMaxSize()
                )
                { innerPadding ->
                    Nav(
                        navController = navHostController ,Modifier.padding(innerPadding))
                }
            }
        }
    }
}

