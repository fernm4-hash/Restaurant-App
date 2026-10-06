package com.example.fernandezhw4



import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainScreenViewModel(var restaurant: RestaurantRepository) : ViewModel(){

    var restList = MutableStateFlow<List<Restaurant>>(emptyList())
    private set

    var showRate = MutableStateFlow(false)
    private set

    init {
        viewModelScope.launch() {
            restaurant.getRestaurants().collect { restaurant ->
                restList.value = restaurant
            }
        }

        viewModelScope.launch {
            restaurant.getShowRating().collect { restaurant ->
                showRate.value = restaurant
            }
        }
    }


}