package com.painfulparse.cigarmadam.data.source.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface CigarDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cigar: CigarEntity)

    @Insert
    suspend fun insertAll(cigars: List<CigarEntity>)

    @Update
    suspend fun update(cigar: CigarEntity)

    @Delete
    suspend fun delete(cigar: CigarEntity)

    @Query("SELECT * FROM cigars WHERE id = :id")
    fun getCigarById(id: Int): Flow<CigarEntity?>

    @Query("SELECT * FROM cigars")
    fun getAll(): Flow<List<CigarEntity>>

    @Query("SELECT * FROM cigars WHERE name LIKE :query")
    fun searchCigarsByName(query: String): Flow<List<CigarEntity>>

    @Query("SELECT * FROM cigars WHERE brand = :brand")
    fun getCigarsByBrand(brand: String): Flow<List<CigarEntity>>

    @Query("SELECT * FROM cigars WHERE bodyFlavor = :flavor ORDER BY rating DESC")
    fun getCigarsByFlavorSortedByRating(flavor: String): Flow<List<CigarEntity>>

    @Query("SELECT COUNT(*) FROM cigars WHERE brand = :brand")
    suspend fun countCigarsByBrand(brand: String): Int

    @Query("SELECT * FROM cigars WHERE origin = :origin AND rating > :minRating")
    fun getCigarsFromOriginWithMinRating(origin: String, minRating: Float): Flow<List<CigarEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(cigar: CigarEntity)

    @Query("DELETE FROM cigars WHERE brand = :brand")
    suspend fun deleteCigarsByBrand(brand: String)

    @Query("SELECT DISTINCT brand FROM cigars")
    fun getAllBrands(): Flow<List<String>>

    @Query("SELECT * FROM cigars WHERE rating BETWEEN :minRating AND :maxRating")
    fun getCigarsWithinRatingRange(minRating: Float, maxRating: Float): Flow<List<CigarEntity>>

    @Query("SELECT * FROM cigars ORDER BY rating DESC LIMIT :limit")
    fun getTopRatedCigars(limit: Int): Flow<List<CigarEntity>>
}