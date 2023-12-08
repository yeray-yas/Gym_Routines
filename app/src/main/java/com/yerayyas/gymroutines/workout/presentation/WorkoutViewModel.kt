package com.yerayyas.gymroutines.workout.presentation


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yerayyas.gymroutines.core.domain.model.WorkoutLog
import com.yerayyas.gymroutines.workout.domain.useCases.CreateWorkoutUseCase
import com.yerayyas.gymroutines.workout.domain.useCases.FinishWorkoutUseCase
import com.yerayyas.gymroutines.workout.domain.useCases.GetNextWorkoutIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WorkoutViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getNextWorkoutIdUseCase: GetNextWorkoutIdUseCase,
    private val createWorkoutUseCase: CreateWorkoutUseCase,
    private val finishWorkoutUseCase: FinishWorkoutUseCase
) : ViewModel() {
    var state by mutableStateOf(WorkoutState())


    init {
        val routineId = savedStateHandle["routineId"] ?: -1L

        viewModelScope.launch {
            val workoutId = getNextWorkoutIdUseCase(routineId)
            val workout = createWorkoutUseCase(workoutId)
            state = state.copy(
                workout = workout,
                routineId = routineId
            )
        }
    }

    fun onEvent(event: WorkoutEvent) {
        when (event) {
            is WorkoutEvent.ChangeWeight -> {
                state = state.copy(
                    weight = event.weight,
                )
            }

            WorkoutEvent.FinishWorkout -> {
                viewModelScope.launch {
                    val workoutLog = state.workout?.let {
                        WorkoutLog(
                            id = null,
                            bodyWeight = state.weight.toDouble(),
                            date = state.date,
                            workout = it
                        )

                    }
                    if (workoutLog != null) {
                        finishWorkoutUseCase(state.routineId, workoutLog)
                    }
                }
            }
        }
    }
}
