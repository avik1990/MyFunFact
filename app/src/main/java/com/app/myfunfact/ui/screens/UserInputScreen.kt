package com.app.myfunfact.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.app.myfunfact.ui.AnimalCard
import com.app.myfunfact.ui.ButtonComponent
import com.app.myfunfact.ui.TextComponent
import com.app.myfunfact.ui.TextInputComponent
import com.app.myfunfact.ui.TopBar
import com.app.myfunfact.ui.UserInputViewModel
import com.app.myfunfact.ui.data.UserDataUiEvents

@Composable
fun UserInputScreen(userInputViewModel: UserInputViewModel,
showWelcomeScreen: (valuesPair: Pair<String,String>) -> Unit) {
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            TopBar("Hello There")

            Spacer(modifier = Modifier.height(12.dp))

            TextComponent(textValue = "Let,s learn about you", fontSize = 24.sp)

            Spacer(modifier = Modifier.height(60.dp))

            TextComponent(textValue = "Name", fontSize = 18.sp)

            Spacer(modifier = Modifier.height(10.dp))

            TextInputComponent(onTextChanged = {
                userInputViewModel.onEvent(
                    UserDataUiEvents.UserNameEntered(it)
                )
            })

            Spacer(modifier = Modifier.height(10.dp))

            TextComponent(textValue = "What do you like?", fontSize = 18.sp)

            Row(modifier = Modifier.fillMaxWidth()) {
                AnimalCard("CAT", animalSelected = {
                    userInputViewModel.onEvent(
                        UserDataUiEvents.AnimalSelected(it)
                    )
                },
                    selected = userInputViewModel.uiState.value.animalSelected == "CAT")


                AnimalCard("DOG", animalSelected = {
                    userInputViewModel.onEvent(
                        UserDataUiEvents.AnimalSelected(it)
                    )
                },
                    selected = userInputViewModel.uiState.value.animalSelected == "DOG")
            }

            Spacer(modifier = Modifier.height(10.dp))

            if(!userInputViewModel.uiState.value.nameEntered.isNullOrEmpty()
                && !userInputViewModel.uiState.value.animalSelected.isNullOrEmpty())
            {
                ButtonComponent(
                    goToDetailsScreen = {
                        Log.e("ComingHere====","${userInputViewModel.uiState.value.nameEntered} ${userInputViewModel.uiState.value.animalSelected}")
                        showWelcomeScreen(
                            Pair(userInputViewModel.uiState.value.nameEntered,
                                userInputViewModel.uiState.value.animalSelected)
                        )
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun UserInputScreenPreview() {
    UserInputScreen(UserInputViewModel(), showWelcomeScreen = {})
}