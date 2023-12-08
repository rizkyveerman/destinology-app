package com.ch2_ps397.destinology.core.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ch2_ps397.destinology.core.data.source.local.entity.ItineraryEntity

@Dao
interface ItineraryDao {
    @Query("SELECT * FROM itinerary")
    fun getAllItinerary() : LiveData<List<ItineraryEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItinerary(itinerary: ItineraryEntity)
}