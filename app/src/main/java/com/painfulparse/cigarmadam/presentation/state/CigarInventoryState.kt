package com.painfulparse.cigarmadam.presentation.state

import com.painfulparse.cigarmadam.domain.model.Cigar

data class CigarInventoryState(
    val cigars: List<Cigar> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
