package com.example.fernandezhw4


import kotlinx.coroutines.flow.Flow



class RestaurantRepository(val preferences: MyPreferences, val database: RestaurantDatabase) {

    suspend fun getRestaurants() : Flow<List<Restaurant>>{
        return database.restaurantDao().selectAll()
    }

    suspend fun addRestaurant( restaurant: Restaurant){
        database.restaurantDao().insert(restaurant)
    }

    suspend fun getShowRating() : Flow<Boolean>{
        return preferences.watchShowRating()

    }

    suspend fun setShowRating(boolean: Boolean){
        preferences.updateShowRating(boolean)
    }
}