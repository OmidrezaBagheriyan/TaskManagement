package com.omidrezabagherian.taskmanagement.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.omidrezabagherian.taskmanagement.data.datastore.SettingManager
import com.omidrezabagherian.taskmanagement.data.datastore.Theme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val dataStore = SettingManager(application)

    fun getTheme() = dataStore.getTheme().asLiveData(Dispatchers.IO)

    fun setTheme(isTheme: String) {
        viewModelScope.launch(Dispatchers.IO) {
            dataStore.setTheme(isTheme)
        }
    }
}