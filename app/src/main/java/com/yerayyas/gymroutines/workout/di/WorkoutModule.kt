package com.yerayyas.gymroutines.workout.di

import com.yerayyas.gymroutines.core.data.local.ExerciseDao
import com.yerayyas.gymroutines.core.data.local.RoutineDao
import com.yerayyas.gymroutines.core.data.local.WorkoutDao
import com.yerayyas.gymroutines.core.data.local.WorkoutLogDao
import com.yerayyas.gymroutines.core.data.local.WorkoutSetDao
import com.yerayyas.gymroutines.workout.data.repository.WorkoutRepositoryImpl
import com.yerayyas.gymroutines.workout.domain.repository.WorkoutRepository
import com.yerayyas.gymroutines.workout.domain.useCases.CreateWorkoutUseCase
import com.yerayyas.gymroutines.workout.domain.useCases.GetNextWorkoutIdUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class WorkoutModule {

    @Singleton
    @Provides
    fun provideWorkoutRepository(
        routineDao: RoutineDao,
        workoutDao: WorkoutDao,
        workoutSetDao: WorkoutSetDao,
        exerciseDao: ExerciseDao,
        workoutLogDao: WorkoutLogDao
    ): WorkoutRepository {
        return WorkoutRepositoryImpl(routineDao, workoutDao, exerciseDao, workoutSetDao, workoutLogDao)
    }

    @Singleton
    @Provides
    fun provideGetWorkoutUseCase(repository: WorkoutRepository): GetNextWorkoutIdUseCase {
        return GetNextWorkoutIdUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideCreateWorkoutUseCase(repository: WorkoutRepository): CreateWorkoutUseCase {
        return CreateWorkoutUseCase(repository)
    }
}