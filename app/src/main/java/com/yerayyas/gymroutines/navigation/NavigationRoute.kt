package com.yerayyas.gymroutines.navigation

sealed class NavigationRoute(val route: String) {
    object Home: NavigationRoute("home")
    object Workout: NavigationRoute("workout")
}