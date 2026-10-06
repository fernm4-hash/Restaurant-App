package com.example.fernandezhw4

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.MutablePreferences
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.fernandezhw4.MyPreferences.PreferenceKeys.showRating
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
class MyPreferences (val context: Context) {
    private object PreferenceKeys {
        val showRating : Preferences.Key<Boolean> = booleanPreferencesKey("showRating")
    }
    suspend fun updateShowRating(newShowRatingValue: Boolean) =
        context.dataStore.edit { preferences: MutablePreferences ->
            preferences[showRating] = newShowRatingValue
        }
    fun watchShowRating(): Flow<Boolean> = context.dataStore.data.map { preferences: Preferences ->
        return@map preferences[showRating] ?: false
    }
}