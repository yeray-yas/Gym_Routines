package com.yerayyas.gymroutines.core.data.mapper

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

fun Workout.toEntity(routineId: String): WorkoutEntity {
    return WorkoutEntity(
        workoutId = this.id,
        name = this.name,
        routineId = routineId
    )
}

fun ExerciseEntity.toDomain(sets: List<WorkoutSet>): Exercise {
    return Exercise(
        id = this.exerciseId,
        name = this.name,
        sets = sets
    )
}

fun Exercise.toEntity(workoutId: String): ExerciseEntity {
    return ExerciseEntity(
        exerciseId = this.id,
        name = this.name,
        workoutId = workoutId
    )
}

fun WorkoutSetEntity.toDomain(): WorkoutSet {
    return WorkoutSet(
        weight = this.weight,
        repetitions = this.repetitions,
        id = this.workoutSetId!!  // TODO: Quitar estos signos de exclamación
    )
}

fun WorkoutSet.toEntity(exerciseId: String): WorkoutSetEntity {
    return WorkoutSetEntity(
        workoutSetId = this.id,
        weight = this.weight,
        repetitions = this.repetitions,
        exerciseId = exerciseId
    )
}

/*
fun WorkoutLogEntity.toDomain(): WorkoutLog {
    return WorkoutLog(
        id = ,
        bodyWeight = ,
        date = ,
        workout =
    )
}

fun WorkoutLog.toEntity(routineId: String): WorkoutLogEntity {
    return WorkoutLogEntity(
       workoutLogId = ,
        bodyWeight = ,
        date = ,
        workoutId = ,
        routineId =
    )
}*/
