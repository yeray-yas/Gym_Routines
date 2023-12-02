package com.yerayyas.gymroutines.core.data.local

import com.yerayyas.gymroutines.core.data.local.entities.ExerciseEntity
import com.yerayyas.gymroutines.core.data.local.entities.RoutineEntity
import com.yerayyas.gymroutines.core.data.local.entities.WorkoutEntity
import com.yerayyas.gymroutines.core.data.local.entities.WorkoutSetEntity
import com.yerayyas.gymroutines.core.domain.model.Exercise
import com.yerayyas.gymroutines.core.domain.model.Routine
import com.yerayyas.gymroutines.core.domain.model.Workout
import com.yerayyas.gymroutines.core.domain.model.WorkoutSet
import java.util.UUID

object FakeDatabase {
    val fakeRoutine = RoutineEntity("routine1", "3x Workout")
    val fakeWorkoutA = WorkoutEntity("workouta", "Workout A", "routine1")

    val fakeExercise1 = ExerciseEntity("ex1", "Bench Press", "workouta")
    val fakeSets1 = WorkoutSetEntity(null, 10.0, 5, "ex1")
    val fakeSets2 = WorkoutSetEntity(null, 10.0, 5, "ex1")
    val fakeSets3 = WorkoutSetEntity(null, 5.0, 8, "ex1")

    val fakeExercise2 = ExerciseEntity("ex2", "DeadLift", "workouta")
    val fakeSets4 = WorkoutSetEntity(null, 10.0, 5, "ex2")
    val fakeSets5 = WorkoutSetEntity(null, 10.0, 5, "ex2")



    val fakeWorkoutB = WorkoutEntity("workoutb", "Workout B", "routine1")

    val fakeExercise3 = ExerciseEntity("ex3", "Squats", "workoutb")
    val fakeSets6 = WorkoutSetEntity(null, 10.0, 5, "ex3")
    val fakeSets7 = WorkoutSetEntity(null, 10.0, 5, "ex3")

    val fakeExercise4 = ExerciseEntity("ex4", "Bench Press", "workoutb")
    val fakeSets8 = WorkoutSetEntity(null, 10.0, 5, "ex4")
    val fakeSets9 = WorkoutSetEntity(null, 10.0, 5, "ex4")

}