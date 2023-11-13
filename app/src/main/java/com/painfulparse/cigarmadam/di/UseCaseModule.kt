package com.painfulparse.cigarmadam.di

import com.painfulparse.cigarmadam.feature_cigars.domain.repository.CigarRepository
import com.painfulparse.cigarmadam.feature_cigars.domain.usecases.AddCigar
import com.painfulparse.cigarmadam.feature_cigars.domain.usecases.DeleteCigar
import com.painfulparse.cigarmadam.feature_cigars.domain.usecases.GetAllCigars
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideGetAllCigarsUseCase(repository: CigarRepository): GetAllCigars {
        return GetAllCigars(repository)
    }

    @Provides
    fun provideAddCigarUseCase(repository: CigarRepository): AddCigar {
        return AddCigar(repository)
    }

    @Provides
    fun provideDeleteCigarUseCase(repository: CigarRepository): DeleteCigar {
        return DeleteCigar(repository)
    }
}