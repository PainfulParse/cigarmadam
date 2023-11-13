package com.painfulparse.cigarmadam.feature_cigars.domain.util

sealed class CigarOrder(val orderType: OrderType) {
    class Brand(orderType: OrderType): CigarOrder(orderType)
    class Date(orderType: OrderType): CigarOrder(orderType)
    class Flavor(orderType: OrderType): CigarOrder(orderType)
    class Size(orderType: OrderType): CigarOrder(orderType)
    class Wrapper(orderType: OrderType): CigarOrder(orderType)

    fun copy(orderType: OrderType): CigarOrder {
        return when(this) {
            is Brand -> Brand(orderType)
            is Date -> Date(orderType)
            is Flavor -> Flavor(orderType)
            is Size -> Size(orderType)
            is Wrapper -> Wrapper(orderType)
        }
    }
}
