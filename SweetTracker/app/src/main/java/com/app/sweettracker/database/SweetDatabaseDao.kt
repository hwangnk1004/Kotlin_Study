package com.app.sweettracker.database

import androidx.room.Dao
import androidx.room.Insert


@Dao
interface SweetDatabaseDao {

    @Insert
    fun insert(tracking: Tracking, trackingDetail: TrackingDetail)



}