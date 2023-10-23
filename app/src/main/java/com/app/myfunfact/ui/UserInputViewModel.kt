package com.app.myfunfact.ui

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.app.myfunfact.ui.data.UserDataUiEvents
import com.app.myfunfact.ui.data.UserInputScreenState

class UserInputViewModel : ViewModel() {

    var uiState = mutableStateOf(UserInputScreenState())

    companion object{
        const val TAG = "UserInputViewModel"
    }
    fun onEvent(event: UserDataUiEvents) {
        when(event){
            is UserDataUiEvents.UserNameEntered -> {
                uiState.value =  uiState.value.copy(
                    nameEntered = event.name
                )
                Log.d(TAG,"onEvent:UserNameEntered->> ")
                Log.d(TAG,"${uiState.value}")
            }

            is UserDataUiEvents.AnimalSelected -> {
                uiState.value =  uiState.value.copy(
                    animalSelected = event.animalSelected
                )
                Log.d(TAG,"onEvent:AnimalSelected->> ")
                Log.d(TAG,"${uiState.value}")
            }
        }
    }
}




