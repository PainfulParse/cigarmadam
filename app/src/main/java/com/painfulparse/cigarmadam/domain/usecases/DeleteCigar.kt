package com.painfulparse.cigarmadam.domain.usecases

import com.painfulparse.cigarmadam.domain.model.Cigar
import com.painfulparse.cigarmadam.domain.repository.CigarRepository

class DeleteCigar(private val repository: CigarRepository) {

    suspend operator fun invoke(cigar: Cigar) = repository.deleteCigar(cigar)
}