package com.painfulparse.cigarmadam.feature_cigars.domain.usecases

import com.painfulparse.cigarmadam.feature_cigars.domain.model.Cigar
import com.painfulparse.cigarmadam.feature_cigars.domain.repository.CigarRepository

class AddCigar(private val repository: CigarRepository) {

    suspend operator fun invoke(cigar: Cigar) = repository.insertCigar(cigar)
}