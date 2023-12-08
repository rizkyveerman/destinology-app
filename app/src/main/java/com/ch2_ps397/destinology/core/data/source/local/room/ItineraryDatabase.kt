package com.ch2_ps397.destinology.core.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ch2_ps397.destinology.core.data.source.local.entity.ItineraryEntity

@Database(entities = [ItineraryEntity::class], version = 1, exportSchema = false)
abstract class ItineraryDatabase: RoomDatabase() {
    abstract fun itineraryDao(): ItineraryDao

    companion object {
        @Volatile
        private var INSTANCE: ItineraryDatabase? = null

        fun getInstance(context: Context): ItineraryDatabase =
            INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ItineraryDatabase::class.java,
                    "Itinerary.db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
    }
}