package com.example.fernandezhw4

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Restaurant(
    @PrimaryKey val name: String,
    @ColumnInfo(name = "location") val location: String?,
    @ColumnInfo(name = "rating") val rating: Double?
)