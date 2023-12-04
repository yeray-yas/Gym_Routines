package com.yerayyas.gymroutines.workout.presentation

sealed interface WorkoutEvent {
    data class ChangeWeight(val weight: String) : WorkoutEvent

    object FinishWorkout: WorkoutEvent
}
