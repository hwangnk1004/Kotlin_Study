package com.app.sweettracker.database

import androidx.room.ColumnInfo
import androidx.room.Entity


@Entity(tableName = "tracking_detail_table")
data class TrackingDetail (


    @ColumnInfo(name = "time")
    var time: String,

    @ColumnInfo(name = "where")
    var where: String,

    @ColumnInfo(name = "status")
    var status: String


)