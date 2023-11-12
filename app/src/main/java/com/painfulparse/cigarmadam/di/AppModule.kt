package com.painfulparse.cigarmadam.di

import com.painfulparse.cigarmadam.domain.usecases.AddCigar
import com.painfulparse.cigarmadam.domain.usecases.DeleteCigar
import com.painfulparse.cigarmadam.domain.usecases.GetAllCigars
import com.painfulparse.cigarmadam.domain.usecases.base.UseCaseProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [DatabaseModule::class, UseCaseModule::class])
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideUseCaseProvider(
        getAllCigars: GetAllCigars,
        addCigar: AddCigar,
        deleteCigar: DeleteCigar
    ): UseCaseProvider {
        return UseCaseProvider(getAllCigars, addCigar, deleteCigar)
    }
}