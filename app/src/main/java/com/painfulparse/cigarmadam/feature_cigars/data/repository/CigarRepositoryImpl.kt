package com.painfulparse.cigarmadam.feature_cigars.data.repository

import com.painfulparse.cigarmadam.feature_cigars.data.mappers.CigarMapper.toDomainModel
import com.painfulparse.cigarmadam.feature_cigars.data.mappers.CigarMapper.toEntity
import com.painfulparse.cigarmadam.feature_cigars.data.source.local.CigarDao
import com.painfulparse.cigarmadam.feature_cigars.domain.model.Cigar
import com.painfulparse.cigarmadam.feature_cigars.domain.repository.CigarRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CigarRepositoryImpl(private val cigarDao: CigarDao) : CigarRepository {

    override suspend fun insertCigar(cigar: Cigar) = cigarDao.insert(cigar.toEntity())

    override suspend fun updateCigar(cigar: Cigar) = cigarDao.update(cigar.toEntity())

    override suspend fun deleteCigar(cigar: Cigar) = cigarDao.delete(cigar.toEntity())

    override fun getCigarById(id: Int): Flow<Cigar?> = cigarDao.getCigarById(id).map { entity ->
        entity?.toDomainModel()
    }

    override fun getAllCigars(): Flow<List<Cigar>> = cigarDao.getAll().map { list ->
        list.map { it.toDomainModel() }
    }

    override fun searchCigarsByName(query: String): Flow<List<Cigar>> =
        cigarDao.searchCigarsByName(query).map { list -> list.map { it.toDomainModel() }
    }

    override fun getCigarsByBrand(brand: String): Flow<List<Cigar>> =
        cigarDao.getCigarsByBrand(brand).map { list -> list.map { it.toDomainModel() } }

    override fun getCigarsByFlavorSortedByRating(flavor: String): Flow<List<Cigar>> {
        return cigarDao.getCigarsByFlavorSortedByRating(flavor).map { list ->
            list.map { it.toDomainModel() }
        }
    }
}
