package com.yerayyas.gymroutines.home.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yerayyas.gymroutines.core.data.local.entities.ExerciseEntity
import com.yerayyas.gymroutines.core.data.local.entities.RoutineEntity
import com.yerayyas.gymroutines.core.data.local.entities.WorkoutEntity
import com.yerayyas.gymroutines.core.data.local.entities.WorkoutSetEntity
import com.yerayyas.gymroutines.core.domain.model.Exercise
import com.yerayyas.gymroutines.core.domain.model.Routine
import com.yerayyas.gymroutines.core.domain.model.Workout
import com.yerayyas.gymroutines.core.domain.model.WorkoutSet
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

/*        val setsA = listOf(
            WorkoutSet(
                id = 1,
                weight = 20.0,
                repetitions = 15
            ),
            WorkoutSet(
                id = 2,
                weight = 10.0,
                repetitions = 30
            )
        )

        val setsB = listOf(
            WorkoutSet(
                id = 1,
                weight = 20.0,
                repetitions = 15
            ),
            WorkoutSet(
                id = 2,
                weight = 10.0,
                repetitions = 30
            )
        )

        val exercisesA = listOf(
            Exercise(
                id = "exa1",
                name = "Bench Press",
                sets = setsA
            ),
            Exercise(
                id = "exa2",
                name = "Dead Lift",
                sets = setsA
            )
        )

        val exercisesB = listOf(
            Exercise(
                id = "exb1",
                name = "Squats",
                sets = setsB
            ),
            Exercise(
                id = "exb2",
                name = "Dead Lift",
                sets = setsB
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