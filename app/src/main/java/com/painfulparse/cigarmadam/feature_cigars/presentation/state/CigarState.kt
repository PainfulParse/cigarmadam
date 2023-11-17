package com.painfulparse.cigarmadam.feature_cigars.presentation.state

import com.painfulparse.cigarmadam.feature_cigars.domain.model.Cigar
import com.painfulparse.cigarmadam.feature_cigars.domain.util.CigarOrder
import com.painfulparse.cigarmadam.feature_cigars.domain.util.OrderType

data class CigarInventoryState(
    val cigars: List<Cigar> = emptyList(),
    val cigarOrder: CigarOrder = CigarOrder.Date(OrderType.Descending),
    val isLoading: Boolean = false,
    val error: String? = null
)

sealed class CigarUiState {
    object Saving : CigarUiState()
    object Loading : CigarUiState()
    data class Error(val message: String) : CigarUiState()
}
