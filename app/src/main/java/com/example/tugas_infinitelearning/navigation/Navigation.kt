package com.example.tugas_infinitelearning.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tugas_infinitelearning.model.NameFood
import com.example.tugas_infinitelearning.page.DetailPage
import com.example.tugas_infinitelearning.page.HalamanBottom
import com.example.tugas_infinitelearning.page.LazyColumnPage
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
        composable(NavigationScreen.LazyColumnPage.name) {
            LazyColumnPage(navController = navController)
        }
        composable(NavigationScreen.Detailpage.name + "/{foodId}") { backStackEntry ->
            val foodId = backStackEntry.arguments?.getString("foodId")
            DetailPage(navController = navController, foodId = foodId)
        }
    }
}