package com.painfulparse.cigarmadam.feature_cigars.domain.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}
