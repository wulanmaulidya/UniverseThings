package org.d3if3041.universerthings.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UniverseEntity::class], version = 1, exportSchema = false)
abstract class UniverseDb : RoomDatabase() {
    abstract val dao: UniverseDao
    companion object {
        @Volatile
        private var INSTANCE: UniverseDb? = null
        fun getInstance(context: Context): UniverseDb {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        UniverseDb::class.java,
                        "universethings.db"
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