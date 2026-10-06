package com.example.fernandezhw4

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking


class MyApp : Application() {
    companion object {
        lateinit var repository: RestaurantRepository
    }
    override fun onCreate() {
        super.onCreate()

        val preference = MyPreferences(applicationContext)

        var db : RestaurantDatabase
        val restaurantList = mutableStateOf<List<Restaurant>>(emptyList())

        runBlocking(Dispatchers.IO) {
            db = Room.databaseBuilder(
                applicationContext,
                RestaurantDatabase::class.java, "user"
            ).build()

            db.restaurantDao().deleteAll()

            val r = Restaurant("The Melting Pot", "Farmingdale", 4.0)
            db.restaurantDao()!!.insert(r)

            val r2 = Restaurant("Burger King", "Farmingdale", 2.0)
            db.restaurantDao()!!.insert(r2)
        }






        repository = RestaurantRepository(preference, db)



    }

}
