package com.ch2_ps397.destinology.core.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "itinerary")
data class ItineraryEntity (
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: String,

    @ColumnInfo(name = "id")
    var name: String,

    @ColumnInfo(name = "id")
    var description: String,

    @ColumnInfo(name = "id")
    var address: String,

    @ColumnInfo(name = "id")
    var image: String,
) : Parcelable