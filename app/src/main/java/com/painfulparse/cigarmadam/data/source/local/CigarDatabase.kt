package com.painfulparse.cigarmadam.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CigarEntity::class], version = 1)
abstract class CigarDatabase : RoomDatabase() {

    abstract fun cigarDao(): CigarDao
}
