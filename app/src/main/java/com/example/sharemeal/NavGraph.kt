package com.example.sharemeal

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sharemeal.theme.Greeting

@Composable
fun SetupNavGraph(navController: NavHostController){
    NavHost(navController = navController,
        startDestination = Screen.Home.route ){
        composable(
            route = Screen.Home.route
        ){
            Greeting(navController)
        }
        composable(
            route = Screen.DRegisterScreen.route
        ){
            DRegisterScreen(navController, context = ComponentActivity())
        }
        composable(
            route = Screen.Dlogin.route
        ){
            DLoginScreen(navController, context = ComponentActivity() )
        }
        composable(
            route = Screen.NRegisterScreen.route
        ){
            NRegisterScreen(navController, context = ComponentActivity())
        }
        composable(
            route = Screen.Nlogin.route
        ){
            NLoginScreen(navController , context = ComponentActivity())
        }
        composable(
            route = Screen.DMenu.route
        ){
            DMenu(navController )
        }
        composable(
            route = Screen.DDonate.route
        ){
            DDonate(navController )
        }
        composable(
            route = Screen.DHistoryScreen.route
        ){
            DHistoryScreen(navController )
        }
        composable(
            route = Screen.NMenu.route
        ){
            NMenu(navController)
        }
        composable(
            route = Screen.DStatus.route
        ){
            DStatus()
        }
        composable(
            route = Screen.CheckDonations.route
        ){
            CheckD(navController)
        }







    }
}