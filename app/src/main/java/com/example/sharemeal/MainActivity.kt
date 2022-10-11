package com.example.sharemeal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.sharemeal.ui.theme.ShareMealTheme

class MainActivity : ComponentActivity() {
    lateinit var navController:NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShareMealTheme {

                navController= rememberNavController()
                SetupNavGraph(navController = navController)


                 // A surface container using the 'background' color from the theme
               // Surface(
                 //   modifier = Modifier.fillMaxSize(),
                   // color = MaterialTheme.colors.background
                //) {
                    //Greeting("Android")
                    //RegisterScreen()
                    //LoginScreen()
                //}
            }
        }
    }
}

