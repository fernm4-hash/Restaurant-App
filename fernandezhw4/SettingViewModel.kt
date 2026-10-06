package com.example.fernandezhw4

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class SettingViewModel(val restaurant: RestaurantRepository): ViewModel() {
    var showRate = MutableStateFlow(false)
    private set

    init {
        viewModelScope.launch {
            restaurant.getShowRating().collect { value ->
                showRate.value = value
            }

        }
    }

    fun updateShowRating(boolean: Boolean) {
        viewModelScope.launch {
            restaurant.setShowRating(boolean)
        }
    }
}