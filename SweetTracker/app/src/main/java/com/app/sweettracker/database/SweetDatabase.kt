package com.app.sweettracker.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Tracking::class, TrackingDetail::class], version = 1, exportSchema = false)
abstract class SweetDatabase : RoomDatabase() {

    abstract val sweetDatabaseDao: SweetDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: SweetDatabase? = null

        fun getInstance(context: Context): SweetDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SweetDatabase::class.java,
                        "sweet_trackker_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance


            }
        }
    }
}