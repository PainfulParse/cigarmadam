package com.painfulparse.cigarmadam.data.mappers

import com.painfulparse.cigarmadam.data.mappers.CigarMapper.toDomainModel
import com.painfulparse.cigarmadam.data.source.local.CigarEntity
import com.painfulparse.cigarmadam.domain.model.BodyFlavor
import com.painfulparse.cigarmadam.domain.model.Cigar

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
            imageUri = this.imageUri
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
            imageUri = this.imageUri
        )
    }
}