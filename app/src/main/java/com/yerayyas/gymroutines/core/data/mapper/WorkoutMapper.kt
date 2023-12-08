package com.yerayyas.gymroutines.core.data.mapper

import com.yerayyas.gymroutines.core.data.extensions.toTimeStamp
import com.yerayyas.gymroutines.core.data.extensions.toZonedDateTime
import com.yerayyas.gymroutines.core.data.local.entities.ExerciseEntity
import com.yerayyas.gymroutines.core.data.local.entities.WorkoutEntity
import com.yerayyas.gymroutines.core.data.local.entities.WorkoutLogEntity
import com.yerayyas.gymroutines.core.data.local.entities.WorkoutSetEntity
import com.yerayyas.gymroutines.core.data.local.entities.relations.ExerciseWithSets
import com.yerayyas.gymroutines.core.data.local.entities.relations.WorkoutWithExercises
import com.yerayyas.gymroutines.core.domain.model.Exercise
import com.yerayyas.gymroutines.core.domain.model.Workout
import com.yerayyas.gymroutines.core.domain.model.WorkoutLog
import com.yerayyas.gymroutines.core.domain.model.WorkoutSet
import java.time.LocalDateTime

fun WorkoutEntity.toDomain(exercises: List<Exercise>): Workout {
    return Workout(
        id = this.workoutId,
        name = this.name,
        exercises = exercises
    )
}

fun Workout.toEntity(routineId: Long): WorkoutEntity {
    return WorkoutEntity(
        workoutId = this.id,
        name = this.name,
        routineId = routineId,
        creationTime = LocalDateTime.now().toZonedDateTime().toTimeStamp()
    )
}

fun ExerciseEntity.toDomain(sets: List<WorkoutSet>): Exercise {
    return Exercise(
        id = this.exerciseId,
        name = this.name,
        sets = sets
    )
}

fun Exercise.toEntity(workoutId: Long): ExerciseEntity {
    return ExerciseEntity(
        exerciseId = this.id,
        name = this.name,
        workoutId = workoutId
    )
}

fun ExerciseWithSets.toDomain(): Exercise {
    return Exercise(
        id = this.exercise.exerciseId,
        name = this.exercise.name,
        sets = this.sets.map { it.toDomain() }
    )
}

fun WorkoutSetEntity.toDomain(): WorkoutSet {
    return WorkoutSet(
        weight = this.weight,
        repetitions = this.repetitions,
        id = this.workoutSetId
    )
}

fun WorkoutSet.toEntity(exerciseId: Long): WorkoutSetEntity {
    return WorkoutSetEntity(
        workoutSetId = this.id,
        weight = this.weight,
        repetitions = this.repetitions,
        exerciseId = exerciseId
    )
}

/*fun WorkoutLogEntity.toDomain(): WorkoutLog {
    return WorkoutLog(
        id =,
        bodyWeight =,
        date =,
        workout =
    )
}*/

fun WorkoutLog.toEntity(routineId: Long): WorkoutLogEntity {
    return WorkoutLogEntity(
        workoutLogId = this.id,
        bodyWeight = this.bodyWeight,
        date = this.date.toTimeStamp(),
        workoutId = this.workout.id!!, // TODO: quitar las exclamaciones
        routineId = routineId
    )
}

fun WorkoutWithExercises.toDomain(): Workout {
    return Workout(
        id = this.workoutEntity.workoutId,
        name = this.workoutEntity.name,
        exercises = this.exercises.map { it.toDomain() }
    )
}

