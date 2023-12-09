package com.yerayyas.gymroutines.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.yerayyas.gymroutines.home.presentation.HomeScreen
import com.yerayyas.gymroutines.workout.presentation.WorkoutScreen

const val ROUTINE_ID = "routineId"

@Composable
fun NavigationHost(
    navHostController: NavHostController
) {
    NavHost(navController = navHostController, startDestination = NavigationRoute.Home.route) {
        composable(NavigationRoute.Home.route) {
            HomeScreen(
                {
                    navHostController.navigate(NavigationRoute.Workout.route + "?$ROUTINE_ID=$it")
                }
            )
        }

        composable(
            NavigationRoute.Workout.route + "?$ROUTINE_ID={$ROUTINE_ID}",
            arguments = listOf(
                navArgument(ROUTINE_ID) {
                    type = NavType.LongType
                    nullable = false
                    defaultValue = -1L
                }
            )
        ) {
            WorkoutScreen()
        }
    }
}