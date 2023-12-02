package com.yerayyas.gymroutines.home.presentation

import com.yerayyas.gymroutines.core.domain.model.Exercise
import com.yerayyas.gymroutines.core.domain.model.Routine
import com.yerayyas.gymroutines.core.domain.model.Workout
import com.yerayyas.gymroutines.core.domain.model.WorkoutSet
import java.util.UUID

data class HomeState(
    val routines: List<Routine> = emptyList()
)

