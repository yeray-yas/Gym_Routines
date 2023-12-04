package com.yerayyas.gymroutines.workout.presentation

import com.yerayyas.gymroutines.core.domain.model.Workout
import java.time.LocalDate

data class WorkoutState(
    val workout: Workout? = Workout("", "", listOf()),
    val date: LocalDate = LocalDate.now(),
    val weight: String = "0",
    val routineId: String = ""
)
