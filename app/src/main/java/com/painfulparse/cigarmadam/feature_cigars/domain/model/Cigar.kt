package com.painfulparse.cigarmadam.feature_cigars.domain.model

data class Cigar(
    val id: Int,
    val name: String,
    val brand: String,
    val origin: String,
    val description: String,
    val bodyFlavor: BodyFlavor,
    val rating: Float,
    val imageUri: String? = null,
    val timestamp: Long,
)

enum class BodyFlavor {
    MILD, MEDIUM, FULL, EXTRA_FULL
}
