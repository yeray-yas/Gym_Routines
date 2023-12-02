package com.yerayyas.gymroutines.workout.presentation


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yerayyas.gymroutines.workout.domain.useCases.GetNextWorkoutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WorkoutViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getNextWorkoutUseCase: GetNextWorkoutUseCase
) : ViewModel() {
    var state by mutableStateOf(WorkoutState())


    init {
        val routineId = savedStateHandle.get<String>("routineId") ?: "asd"
        viewModelScope.launch {
            val workout = getNextWorkoutUseCase(routineId)
            println(workout)
            println()
        }
    }

    fun onEvent(event: WorkoutEvent) {
        when (event) {
            is WorkoutEvent.ChangeWeight -> {
                state = state.copy(
                    weight = event.weight,
                )
            }
        }
    }
}
