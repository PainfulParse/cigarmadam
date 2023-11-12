package com.painfulparse.cigarmadam.domain.repository

import com.painfulparse.cigarmadam.domain.model.Cigar
import kotlinx.coroutines.flow.Flow

interface CigarRepository {

    suspend fun insertCigar(cigar: Cigar)

    suspend fun updateCigar(cigar: Cigar)

    suspend fun deleteCigar(cigar: Cigar)

    fun getCigarById(id: Int): Flow<Cigar?>

    fun getAllCigars(): Flow<List<Cigar>>

    fun searchCigarsByName(query: String): Flow<List<Cigar>>

    fun getCigarsByBrand(brand: String): Flow<List<Cigar>>

    fun getCigarsByFlavorSortedByRating(flavor: String): Flow<List<Cigar>>
}