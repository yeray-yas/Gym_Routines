package com.yerayyas.gymroutines.workout.data.mapper

import com.yerayyas.gymroutines.core.data.local.entities.ExerciseEntity
import com.yerayyas.gymroutines.core.data.local.entities.WorkoutEntity
import com.yerayyas.gymroutines.core.data.local.entities.WorkoutSetEntity
import com.yerayyas.gymroutines.core.domain.model.Exercise
import com.yerayyas.gymroutines.core.domain.model.Workout
import com.yerayyas.gymroutines.core.domain.model.WorkoutSet

fun WorkoutEntity.toDomain(exercises: List<Exercise>): Workout {
    return Workout(
        id = this.workoutId,
        name = this.name,
        exercises = exercises
    )
}

fun ExerciseEntity.toDomain(sets: List<WorkoutSet>): Exercise {
    return Exercise(
        id = this.exerciseId,
        name = this.name,
        sets = sets
    )
}

fun WorkoutSetEntity.toDomain(): WorkoutSet {
    return WorkoutSet(
        weight = this.weight,
        repetitions = this.repetitions
    )
}