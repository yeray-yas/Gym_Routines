package com.yerayyas.gymroutines.home.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yerayyas.gymroutines.home.domain.useCases.GetRoutinesUseCase
import com.yerayyas.gymroutines.home.domain.useCases.InsertRoutineUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getRoutinesUseCase: GetRoutinesUseCase,
    private val insertRoutineUseCase: InsertRoutineUseCase
) : ViewModel() {
    var state by mutableStateOf(HomeState())

    init {
        viewModelScope.launch {
            getRoutinesUseCase().stateIn(viewModelScope).collectLatest {
                state = state.copy(
                    routines = it
                )
            }
        }

/*        val setsA1 = listOf(
            WorkoutSet(
                id = 1,
                weight = 12.0,
                repetitions = 13
            ),
            WorkoutSet(
                id = 2,
                weight = 14.0,
                repetitions = 15
            )
        )

        val setsA2 = listOf(
            WorkoutSet(
                id = 3,
                weight = 16.0,
                repetitions = 17
            ),
            WorkoutSet(
                id = 4,
                weight = 18.0,
                repetitions = 19
            )
        )

        val setsB1 = listOf(
            WorkoutSet(
                id = 5,
                weight = 20.0,
                repetitions = 21
            ),
            WorkoutSet(
                id = 6,
                weight = 22.0,
                repetitions = 23
            )
        )

        val setsB2 = listOf(
            WorkoutSet(
                id = 7,
                weight = 24.0,
                repetitions = 25
            ),
            WorkoutSet(
                id = 8,
                weight = 26.0,
                repetitions = 27
            )
        )

        val exercisesA = listOf(
            Exercise(
                id = "exa1",
                name = "Bench Press",
                sets = setsA1
            ),
            Exercise(
                id = "exa2",
                name = "Dead Lift",
                sets = setsA2
            )
        )

        val exercisesB = listOf(
            Exercise(
                id = "exb1",
                name = "Squats",
                sets = setsB1
            ),
            Exercise(
                id = "exb2",
                name = "Dead Lift",
                sets = setsB2
            )
        )

        val workouts = listOf(
            Workout(
                "workouta", "Workout A", exercisesA
            ),
            Workout(
                "workoutb", "Workout B", exercisesB
            )
        )

        val routine = Routine(
            "routine1", "3x Workout - BASE DE DATOS", workouts =
            workouts
        )

        viewModelScope.launch {
            try {
                insertRoutineUseCase(routine)
            } catch (e: Exception) {
                println(e)
                println()
            }
            println()
        }*/
    }
}