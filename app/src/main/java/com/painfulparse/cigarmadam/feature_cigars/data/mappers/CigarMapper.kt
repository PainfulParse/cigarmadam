package com.painfulparse.cigarmadam.feature_cigars.data.mappers

import com.painfulparse.cigarmadam.feature_cigars.data.mappers.CigarMapper.toDomainModel
import com.painfulparse.cigarmadam.feature_cigars.data.source.local.CigarEntity
import com.painfulparse.cigarmadam.feature_cigars.domain.model.BodyFlavor
import com.painfulparse.cigarmadam.feature_cigars.domain.model.Cigar

object CigarMapper {

    fun CigarEntity.toDomainModel(): Cigar {
        return Cigar(
            id = this.id,
            name = this.name,
            brand = this.brand,
            origin = this.origin,
            bodyFlavor = BodyFlavor.valueOf(this.bodyFlavor),
            description = this.description,
            rating = this.rating,
            imageUri = this.imageUri,
            timestamp = this.timestamp
        )
    }

    fun Cigar.toEntity(): CigarEntity {
        return CigarEntity(
            id = this.id,
            name = this.name,
            brand = this.brand,
            origin = this.origin,
            bodyFlavor = this.bodyFlavor.name,
            description = this.description,
            rating = this.rating,
            imageUri = this.imageUri,
            timestamp = this.timestamp
        )
    }
}