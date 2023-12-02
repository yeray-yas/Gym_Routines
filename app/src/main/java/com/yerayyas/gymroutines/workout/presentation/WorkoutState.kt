package com.yerayyas.gymroutines.workout.presentation

import android.health.connect.datatypes.WeightRecord
import com.yerayyas.gymroutines.core.domain.model.Workout
import java.time.LocalDate

data class WorkoutState (
    val workout: Workout? = null,
    val today:LocalDate = LocalDate.now(),
    val weight:String = "0"
)
