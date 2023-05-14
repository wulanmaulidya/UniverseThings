package org.d3if3041.universerthings.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "universethings")
data class UniverseEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var tanggal: Long = System.currentTimeMillis(),
    var namaPlanet: String
)
