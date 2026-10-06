package com.example.fernandezhw4


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class AddRestaurantViewModel(var restaurant: RestaurantRepository) : ViewModel(){

    fun insert( name:String, location:String, rating:Double){
        var restaurantData = Restaurant(name,location,rating)


        viewModelScope.launch {
            restaurant.addRestaurant(restaurantData)
        }
    }
    }


