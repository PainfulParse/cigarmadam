package com.painfulparse.cigarmadam.domain.usecases

import com.painfulparse.cigarmadam.domain.model.Cigar
import com.painfulparse.cigarmadam.domain.repository.CigarRepository

class AddCigar(private val repository: CigarRepository) {

    suspend operator fun invoke(cigar: Cigar) = repository.insertCigar(cigar)
}