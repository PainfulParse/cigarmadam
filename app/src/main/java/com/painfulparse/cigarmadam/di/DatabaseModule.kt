package com.painfulparse.cigarmadam.di

import android.content.Context
import androidx.room.Room
import com.painfulparse.cigarmadam.data.repository.CigarRepositoryImpl
import com.painfulparse.cigarmadam.data.source.local.CigarDao
import com.painfulparse.cigarmadam.data.source.local.CigarDatabase
import com.painfulparse.cigarmadam.domain.repository.CigarRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): CigarDatabase {
        return Room.databaseBuilder(
            appContext,
            CigarDatabase::class.java,
            "cigar-database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideCigarDao(database: CigarDatabase): CigarDao {
        return database.cigarDao()
    }

    @Provides
    @Singleton
    fun provideCigarRepository(database: CigarDatabase) : CigarRepository {
        return CigarRepositoryImpl(database.cigarDao())
    }
}