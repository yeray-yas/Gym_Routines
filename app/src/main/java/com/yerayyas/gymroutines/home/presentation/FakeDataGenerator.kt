package com.yerayyas.gymroutines.home.presentation

import com.yerayyas.gymroutines.core.domain.model.Exercise
import com.yerayyas.gymroutines.core.domain.model.Routine
import com.yerayyas.gymroutines.core.domain.model.Workout
import com.yerayyas.gymroutines.core.domain.model.WorkoutSet
import java.util.UUID

object FakeDataGenerator {

    fun createRoutine(): Routine {
        return Routine(
            id = UUID.randomUUID().toString(),
            name = "Full Body Workout",
            workouts = listOf(createWorkoutA(), createWorkoutB())
        )
    }

    private fun createWorkoutA(): Workout {
        return Workout(
            UUID.randomUUID().toString(),
            "Workout A",
            createExercisesA()
        )
    }

    private fun createWorkoutB(): Workout {
        return Workout(
            UUID.randomUUID().toString(),
            "Workout B",
            createExercisesB()
        )
    }

    private fun createExercisesA(): List<Exercise> {

        val compoundSets = listOf(
            WorkoutSet(
                id = null,
                weight = 0.0,
                repetitions = 5
            ),
            WorkoutSet(
                id = null,
                weight = 0.0,
                repetitions = 6
            ),
            WorkoutSet(
                id = null,
                weight = 0.0,
                repetitions = 8
            )
        )

        val isolatedSets = listOf(
            WorkoutSet(
                id = null,
                weight = 0.0,
                repetitions = 12
            ),
            WorkoutSet(
                id = null,
                weight = 0.0,
                repetitions = 12
            )
        )

        return listOf(
            Exercise(
                name = "Squats",
                sets = compoundSets
            ),
            Exercise(
                name = "Bench Press",
                sets = compoundSets
            ),
            Exercise(
                name = "Weighted Chinup",
                sets = compoundSets
            ),
            Exercise(
                name = "Machine Lateral Raises",
                sets = isolatedSets
            ),
            Exercise(
                name = "Diverging Low Row",
                sets = isolatedSets
            ),
            Exercise(
                name = "Triceps Pushdowns",
                sets = isolatedSets
            ),
            Exercise(
                name = "Incline DumbBell Biceps Curl",
                sets = isolatedSets
            )
        )
    }

    private fun createExercisesB(): List<Exercise> {

        val compoundSets = listOf(
            WorkoutSet(
                id = null,
                weight = 0.0,
                repetitions = 5
            ),
            WorkoutSet(
                id = null,
                weight = 0.0,
                repetitions = 6
            ),
            WorkoutSet(
                id = null,
                weight = 0.0,
                repetitions = 8
            )
        )

        val isolatedSets = listOf(
            WorkoutSet(
                id = null,
                weight = 0.0,
                repetitions = 12
            ),
            WorkoutSet(
                id = null,
                weight = 0.0,
                repetitions = 12
            )
        )

        val shrugsSets = listOf(
            WorkoutSet(
                id = null,
                weight = 0.0,
                repetitions = 5
            ),
            WorkoutSet(
                id = null,
                weight = 0.0,
                repetitions = 6
            ),
            WorkoutSet(
                id = null,
                weight = 0.0,
                repetitions = 8
            )
        )

        return listOf(
            Exercise(
                name = "Squats",
                sets = compoundSets
            ),
            Exercise(
                name = "Overhead Press",
                sets = compoundSets
            ),
            Exercise(
                name = "Weighted Chinup",
                sets = compoundSets
            ),
            Exercise(
                name = "DumbBell Shrugs",
                sets = shrugsSets
            ),
            Exercise(
                name = "Pec Dec",
                sets = isolatedSets
            ),
            Exercise(
                name = "Triceps Pushdowns",
                sets = isolatedSets
            ),
            Exercise(
                name = "Incline DumbBell Biceps Curl",
                sets = isolatedSets
            )
        )
    }
}