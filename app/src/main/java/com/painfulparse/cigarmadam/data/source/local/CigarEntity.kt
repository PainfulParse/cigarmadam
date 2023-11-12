package com.painfulparse.cigarmadam.data.source.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.painfulparse.cigarmadam.domain.model.BodyFlavor

@Entity(tableName = "cigars")
data class CigarEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val brand: String,
    val origin: String,
    val description: String,
    val bodyFlavor: String,
    val rating: Float,
    val imageUri: String? = null
)

class BodyFlavorConverter {
    @TypeConverter
    fun toBodyFlavor(value: String) = enumValueOf<BodyFlavor>(value)

    @TypeConverter
    fun fromBodyFlavor(flavor: BodyFlavor) = flavor.name
}
