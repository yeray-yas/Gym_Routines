package com.yerayyas.gymroutines.core.di

import android.content.Context
import androidx.room.Room
import com.yerayyas.gymroutines.core.data.local.ExerciseDao
import com.yerayyas.gymroutines.core.data.local.RoutineDao
import com.yerayyas.gymroutines.core.data.local.WorkoutDao
import com.yerayyas.gymroutines.core.data.local.WorkoutDatabase
import com.yerayyas.gymroutines.core.data.local.WorkoutLogDao
import com.yerayyas.gymroutines.core.data.local.WorkoutSetDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object CoreModule {

    @Provides
    @Singleton
    fun provideWorkDatabase(
        @ApplicationContext context: Context
    ): WorkoutDatabase {
        return Room.databaseBuilder(
            context,
            WorkoutDatabase::class.java,
            "workout db",
        ).build()
    }

    @Provides
    @Singleton
    fun provideWorkoutDao(db:WorkoutDatabase):WorkoutDao{
        return db.workoutDao
    }

    @Provides
    @Singleton
    fun provideWorkoutLogDao(db:WorkoutDatabase): WorkoutLogDao {
        return db.workoutLogDao
    }

    @Provides
    @Singleton
    fun provideRoutineDao(db:WorkoutDatabase):RoutineDao{
        return db.routineDao
    }

    @Provides
    @Singleton
    fun provideWorkoutSetDao(db:WorkoutDatabase):WorkoutSetDao{
        return db.workoutSetDao
    }

    @Provides
    @Singleton
    fun provideExerciseDao(db:WorkoutDatabase):ExerciseDao{
        return db.exerciseDao
    }

}