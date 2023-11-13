package com.painfulparse.cigarmadam.feature_cigars.domain.usecases

import com.painfulparse.cigarmadam.feature_cigars.domain.model.Cigar
import com.painfulparse.cigarmadam.feature_cigars.domain.repository.CigarRepository
import com.painfulparse.cigarmadam.feature_cigars.domain.util.CigarOrder
import com.painfulparse.cigarmadam.feature_cigars.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class GetAllCigars(private val repository: CigarRepository) {

    operator fun invoke(
        cigarOrder: CigarOrder = CigarOrder.Date(OrderType.Descending)
    ): Flow<List<Cigar>> {
        return repository.getAllCigars().map { cigars ->
            when (cigarOrder.orderType) {
                is OrderType.Ascending -> {
                    when (cigarOrder) {
                        is CigarOrder.Date -> cigars.sortedBy { it.timestamp }
                        is CigarOrder.Brand -> TODO()
                        is CigarOrder.Flavor -> TODO()
                        is CigarOrder.Size -> TODO()
                        is CigarOrder.Wrapper -> TODO()
                    }
                }
                is OrderType.Descending -> {
                    when (cigarOrder) {
                        is CigarOrder.Date -> cigars.sortedByDescending { it.timestamp }
                        is CigarOrder.Brand -> TODO()
                        is CigarOrder.Flavor -> TODO()
                        is CigarOrder.Size -> TODO()
                        is CigarOrder.Wrapper -> TODO()
                    }
                }
            }
        }
    }
}