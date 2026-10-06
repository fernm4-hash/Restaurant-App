package com.example.fernandezhw4

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun AddRestaurantScreen(){
    val viewModel = viewModel { AddRestaurantViewModel(MyApp.repository) }

    var name by rememberSaveable() { mutableStateOf("")}
    var location by rememberSaveable() { mutableStateOf("")}
    var rating by rememberSaveable() { mutableStateOf("")}

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding( 20.dp),
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 30.dp
    ){
        Column() {
            Heading("Add Restaurant")
            TextField(
                modifier = Modifier.padding(10.dp),
                value = name,
                onValueChange = {name = it},
                label = {Text("Name")}
            )
            TextField(
                modifier = Modifier.padding(10.dp),
                value = location,
                onValueChange = {location = it},
                label = {Text("Location")}
            )
            TextField(
                modifier = Modifier.padding(10.dp),
                value = rating,
                onValueChange = {rating = it},
                label = {Text("Rating")}
            )

            Button(
                modifier = Modifier.padding(10.dp),
                onClick = {
                viewModel.insert(name,location,rating.toDouble())
                    name = ""
                    location = ""
                    rating = ""
            }) {
                Text("Add")  }

        }
    }


}