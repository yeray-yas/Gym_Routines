package com.yerayyas.gymroutines.workout.data.repository

import com.yerayyas.gymroutines.core.data.local.FakeDatabase
import com.yerayyas.gymroutines.core.domain.model.Workout
import com.yerayyas.gymroutines.workout.data.mapper.toDomain
import com.yerayyas.gymroutines.workout.domain.repository.WorkoutRepository

class WorkoutRepositoryImpl: WorkoutRepository {
    override suspend fun getAllWorkoutsByRoutine(id: String): List<Workout> {
        val workoutA = FakeDatabase.fakeWorkoutA
            val workoutB = FakeDatabase.fakeWorkoutB

        val exercisesA1 = FakeDatabase.fakeExercise1
            val exA1set1 = FakeDatabase.fakeSets1
            val exA1set2 = FakeDatabase.fakeSets2
            val exA1set3 = FakeDatabase.fakeSets3

        val exercisesA2 = FakeDatabase.fakeExercise2
            val exA2set1 = FakeDatabase.fakeSets4
            val exA2set2 = FakeDatabase.fakeSets5

        val exercisesB1 = FakeDatabase.fakeExercise3
            val exB1set1 = FakeDatabase.fakeSets6
            val exB1set2 = FakeDatabase.fakeSets7

        val exercisesB2 = FakeDatabase.fakeExercise4
            val exB2set1 = FakeDatabase.fakeSets7
            val exB2set2 = FakeDatabase.fakeSets8

        val setsA1 = listOf(exA1set1.toDomain(), exA1set2.toDomain(), exA1set3.toDomain())
        val setsA2 = listOf(exA2set1.toDomain(), exA2set2.toDomain())

        val setsB1 = listOf(exB1set1.toDomain(), exB1set2.toDomain())
        val setsB2 = listOf(exB2set1.toDomain(), exB2set2.toDomain())

        val exercisesA = listOf(exercisesA1.toDomain(setsA1), exercisesA2.toDomain(setsA2))
        val exercisesB = listOf(exercisesB1.toDomain(setsB1), exercisesB2.toDomain(setsB2))

        return listOf(
            workoutA.toDomain(exercisesA),
            workoutB.toDomain(exercisesB)
        )
    }
}