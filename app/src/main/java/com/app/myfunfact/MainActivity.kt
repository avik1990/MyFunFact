package com.app.myfunfact

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.myfunfact.ui.screens.FunFactAppNavigationGraph
import com.app.myfunfact.ui.screens.Routes
import com.app.myfunfact.ui.screens.UserInputScreen
import com.app.myfunfact.ui.screens.WelcomeScreen
import com.app.myfunfact.ui.theme.MyFunFactTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFunFactTheme {
                FunFactApp()
            }
        }
    }

    @Composable
    private fun FunFactApp() {
        FunFactAppNavigationGraph()
    }
}

