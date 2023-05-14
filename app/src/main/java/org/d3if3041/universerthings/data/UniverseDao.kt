package org.d3if3041.universerthings.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UniverseDao {
    @Insert
    fun insert(unniversethings: UniverseEntity)

    @Query("SELECT * FROM universethings ORDER BY id DESC")
    fun getLastUniverse(): LiveData<List<UniverseEntity>>

    @Query("DELETE FROM universethings")
    fun clearData()
}