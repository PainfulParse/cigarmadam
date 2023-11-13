package com.painfulparse.cigarmadam.di

import com.painfulparse.cigarmadam.feature_cigars.domain.usecases.AddCigar
import com.painfulparse.cigarmadam.feature_cigars.domain.usecases.DeleteCigar
import com.painfulparse.cigarmadam.feature_cigars.domain.usecases.GetAllCigars
import com.painfulparse.cigarmadam.feature_cigars.domain.usecases.CigarUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [DatabaseModule::class, UseCaseModule::class])
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideCigarUseCases(
        getAllCigars: GetAllCigars,
        addCigar: AddCigar,
        deleteCigar: DeleteCigar
    ): CigarUseCases {
        return CigarUseCases(getAllCigars, addCigar, deleteCigar)
    }
}