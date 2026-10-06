package com.example.fernandezhw4

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun SettingsScreen(){
    val viewModel = viewModel { SettingViewModel(MyApp.repository) }

    val showRating by viewModel.showRate.collectAsState()

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(20.dp),
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 30.dp
    ){
    Column() {
        Heading("Setting")
        DefaultText("Show Rating =  $showRating" )
        Switch(
            checked = showRating,
            modifier = Modifier.padding(10.dp),
            onCheckedChange = { newValue ->
                viewModel.updateShowRating(newValue)
            })
        }
    }


}