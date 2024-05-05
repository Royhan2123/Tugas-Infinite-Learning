package com.example.tugas_infinitelearning.navigation

enum class NavigationScreen {
    SplashScreen,
    LazyColumnPage,
    LazyGridPage,
    AccountPage,
    Detailpage,
    HalamanBottom;

    fun fromRoute(route:String): NavigationScreen =
        when(route.substringBefore("/")) {
            SplashScreen.name -> SplashScreen
            LazyColumnPage.name -> LazyColumnPage
            LazyGridPage.name -> LazyGridPage
            AccountPage.name -> AccountPage
            Detailpage.name -> Detailpage
            HalamanBottom.name -> HalamanBottom
            else -> throw IllegalArgumentException("$route Route is not a recognized")
        }
}