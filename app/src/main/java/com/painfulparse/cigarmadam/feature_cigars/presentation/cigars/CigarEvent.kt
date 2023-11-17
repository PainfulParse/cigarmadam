package com.painfulparse.cigarmadam.feature_cigars.presentation.cigars

import com.painfulparse.cigarmadam.feature_cigars.domain.model.Cigar
import com.painfulparse.cigarmadam.feature_cigars.domain.util.CigarOrder

sealed class CigarEvent {

    data class Order(val cigarOrder: CigarOrder): CigarEvent()

    data class AddCigar(val cigar: Cigar): CigarEvent()

    data class DeleteCigar(val cigar: Cigar): CigarEvent()

    object RestoreCigar: CigarEvent()

    object ToggleOrderSection: CigarEvent()
}