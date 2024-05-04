package com.example.tugas_infinitelearning.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tugas_infinitelearning.page.HalamanBottom
import com.example.tugas_infinitelearning.page.SplashScreen


@Composable
fun Navigations() {
    val navController = rememberNavController()


    NavHost(
        navController = navController,
        startDestination = NavigationScreen.SplashScreen.name
    ) {
        composable(NavigationScreen.SplashScreen.name) {
            SplashScreen(navController = navController)
        }
        composable(NavigationScreen.HalamanBottom.name) {
            HalamanBottom()
        }
        composable(NavigationScreen.SplashScreen.name) {
            SplashScreen(navController = navController)
        }
        composable(NavigationScreen.SplashScreen.name) {
            SplashScreen(navController = navController)
        }
    }
}