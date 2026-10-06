package com.example.fernandezhw4

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun MainScreen(){

    val viewModel = viewModel { MainScreenViewModel(MyApp.repository) }
    val restaurantList by viewModel.restList.collectAsState()
    val showRating by viewModel.showRate.collectAsState()

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(  20.dp),
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 30.dp
    ){
        Column(modifier = Modifier) {
            Heading("Restaurants")

            LazyColumn() {
                items(restaurantList){ restaurant ->
                    TitleDefaultText(restaurant.name)
                    DefaultText("Location: ${restaurant.location.toString()}")
                    if(showRating){
                        DefaultText("Rating: ${restaurant.rating.toString()}")
                    }

                } }
            }




        }
    }



