package org.d3if3041.universerthings.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if3041.universerthings.data.UniverseDao
import org.d3if3041.universerthings.data.UniverseEntity
import org.d3if3041.universerthings.model.HasilUniverse
import org.d3if3041.universerthings.model.cariUniverse

class MainViewModel (private val db: UniverseDao) : ViewModel() {
    private val hasilUniverse = MutableLiveData<HasilUniverse>()
    fun cariUniverse(planet:String) {
        val dataUniverse = UniverseEntity(
            namaPlanet = planet
        )
        hasilUniverse.value = dataUniverse.cariUniverse()
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.insert(dataUniverse)
            }
        }
    }

    fun getHasilUniverse(): LiveData<HasilUniverse> = hasilUniverse

}