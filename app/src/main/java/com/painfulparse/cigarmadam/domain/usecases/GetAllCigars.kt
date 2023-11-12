package com.painfulparse.cigarmadam.domain.usecases

import com.painfulparse.cigarmadam.domain.model.Cigar
import com.painfulparse.cigarmadam.domain.repository.CigarRepository
import kotlinx.coroutines.flow.first

class GetAllCigars(private val repository: CigarRepository) {

    suspend operator fun invoke(): List<Cigar> = repository.getAllCigars().first()
}