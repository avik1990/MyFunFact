package com.app.myfunfact.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.myfunfact.R
import com.app.myfunfact.ui.data.UserDataUiEvents

@Composable
fun TopBar(value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            value,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                color = Color.Black
            )
        )

        Spacer(modifier = Modifier.weight(1f))

        Image(
            modifier = Modifier
                .height(40.dp)
                .width(40.dp),
            painter = painterResource(id = R.drawable.ic_profile),
            contentDescription = "Logo"
        )
    }
}

@Composable
fun TextComponent(
    textValue: String,
    fontSize: TextUnit,
    colorValue: Color = Color.Black
) {
    Text(

        text = textValue,
        fontSize = fontSize,
        style = TextStyle(
            color = colorValue,
            fontWeight = FontWeight.Light
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInputComponent(
    onTextChanged: (name: String) -> Unit
) {
    var currentValue by remember {
        mutableStateOf("")
    }

    val localFocusManager = LocalFocusManager.current

    OutlinedTextField(
        value = currentValue, onValueChange = {
            currentValue = it
            onTextChanged(it)
        },
        modifier = Modifier.fillMaxWidth(),
        placeholder = {
            Text(text = "Enter Your Name", fontSize = 18.sp)
        },
        textStyle = TextStyle.Default.copy(fontSize = 24.sp),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ), keyboardActions = KeyboardActions {
            localFocusManager.clearFocus()
        }
    )
}

@Composable
fun AnimalCard(
    textValue: String, selected: Boolean,
    animalSelected: (animalName: String) -> Unit
) {
    val localFocusManager = LocalFocusManager.current
    Card(
        modifier = Modifier
            .padding(24.dp)
            .size(130.dp),
        elevation = CardDefaults.cardElevation(4.dp),

        ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = 1.dp,
                    color = if (selected) Color.Green else Color.Transparent,
                    shape = RoundedCornerShape(8.dp)
                ),
            contentAlignment = Alignment.Center,


            ) {
            Text(
                modifier = Modifier.clickable {
                    val animalName = if (textValue == "CAT") "CAT" else "DOG"
                    animalSelected(animalName)
                    localFocusManager.clearFocus()
                },
                text = textValue,
                fontSize = 25.sp,
                style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                ),
                textAlign = TextAlign.Center,

                )
        }

    }
}

@Composable
fun ButtonComponent(
    goToDetailsScreen: () -> Unit
) {
    Button(
        onClick = {
            goToDetailsScreen()
        },
        modifier = Modifier.fillMaxWidth()
    ) {
        TextComponent(textValue = "Details Screen", fontSize = 18.sp, colorValue = Color.White)
    }
}


@Composable
fun TextWithShadow(value: String) {
    val shadowOffset = Offset(x = 1f, y = 2f)
    Text(
        text = value,
        fontSize = 24.sp,
        fontWeight = FontWeight.Light,
        style = TextStyle
            (
            shadow = Shadow(Color.Green, shadowOffset, 2f)
        )
    )

}

@Preview(showBackground = true)
@Composable
fun AnimalCardPreview() {
    AnimalCard("", false, { "DOG" })
}


@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar("")
}

@Preview(showBackground = true)
@Composable
fun TextComponentPreview() {
    TextComponent(textValue = "Native JetCompose", fontSize = 24.sp)
}