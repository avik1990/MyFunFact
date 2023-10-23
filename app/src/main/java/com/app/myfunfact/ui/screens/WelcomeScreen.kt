package com.app.myfunfact.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.myfunfact.ui.TextComponent
import com.app.myfunfact.ui.TextWithShadow
import com.app.myfunfact.ui.TopBar

@Composable
fun WelcomeScreen(name: String?, animalSelected: String?) {
    println("Hello Brother")
    println("$name $animalSelected")
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)) {

            TopBar("This is Details Page!!")

            Spacer(modifier = Modifier.height(12.dp))

            TextComponent(textValue = "This is details page====", fontSize = 24.sp)

            Spacer(modifier = Modifier.height(12.dp))

            val finalText = if(animalSelected == "CAT") "You are cat lover" else "You are dog lover"

            TextWithShadow(value = finalText)

        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen("name", "animalSelected")
}