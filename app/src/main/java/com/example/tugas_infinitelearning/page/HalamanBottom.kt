package com.example.tugas_infinitelearning.page

import android.annotation.SuppressLint
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.BrowseGallery
import androidx.compose.material.icons.filled.GridOn
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.BrowseGallery
import androidx.compose.material.icons.outlined.GridOn
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tugas_infinitelearning.model.NameFood
import com.example.tugas_infinitelearning.model.loadFood
import com.example.tugas_infinitelearning.navigation.NavigationScreen
import com.example.tugas_infinitelearning.ui.theme.blue
import com.example.tugas_infinitelearning.ui.theme.lightGray


sealed class BottomNavigationScreen(
    val title: String,
    val filledIcon: ImageVector,
    val outlinedIcon: ImageVector
) {
    data object LazyColumn :
        BottomNavigationScreen("Lazy Column", Icons.Filled.Home, Icons.Outlined.Home)

    data object LazyRow :
        BottomNavigationScreen("Lazy Row", Icons.Filled.BrowseGallery, Icons.Outlined.BrowseGallery)

    data object LazyGrid :
        BottomNavigationScreen("Lazy Grid", Icons.Filled.GridOn, Icons.Outlined.GridOn)

    data object AccountScreen :
        BottomNavigationScreen("Account", Icons.Filled.AccountCircle, Icons.Outlined.AccountCircle)

}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HalamanBottom() {
    val navController = rememberNavController()

    val items = listOf(
        BottomNavigationScreen.LazyColumn,
        BottomNavigationScreen.LazyRow,
        BottomNavigationScreen.LazyGrid,
        BottomNavigationScreen.AccountScreen,
    )

    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = Color.White,
                elevation = 10.dp
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                items.forEach { screen ->
                    BottomNavigationItem(
                        selected = currentRoute == screen.title,
                        onClick = {
                            navController.navigate(screen.title) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                            }
                        },
                        icon = {
                            val selectedIcon =
                                if (currentRoute == screen.title) screen.filledIcon else screen.outlinedIcon
                            Icon(
                                selectedIcon, contentDescription = screen.title,
                                tint = if (currentRoute == screen.title) blue else lightGray
                            )
                        },
                        label = {
                            Text(
                                text = screen.title,
                                color = if (currentRoute == screen.title)
                                    blue else lightGray
                            )
                        },
                        alwaysShowLabel = false
                    )
                }
            }
        },
        content = {
            NavHost(
                navController = navController,
                startDestination = BottomNavigationScreen.LazyColumn.title
            ) {
                composable(BottomNavigationScreen.LazyColumn.title) {
                    LazyColumnPage(navController = navController)
                }
                composable(BottomNavigationScreen.LazyRow.title) {
                    LazyRowPage(navController = navController)
                }
                composable(BottomNavigationScreen.LazyGrid.title) {
                    LazyGridPage(navController = navController)
                }
                composable(BottomNavigationScreen.AccountScreen.title) {
                    AccountPage(navController = navController)
                }
                composable(NavigationScreen.Detailpage.name + "/{foodId}") { backStackEntry ->
                    val foodId = backStackEntry.arguments?.getString("foodId")
                    DetailPage(navController = navController, foodId = foodId)
                }
            }
        }
    )
}

@Preview
@Composable
fun PreviewBottomNavigation() {
    HalamanBottom()
}