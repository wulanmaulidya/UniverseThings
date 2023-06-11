package org.d3if3041.universerthings.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if3041.universerthings.MainActivity
import org.d3if3041.universerthings.data.UniverseDao
import org.d3if3041.universerthings.data.UniverseEntity
import org.d3if3041.universerthings.model.HasilUniverse
import org.d3if3041.universerthings.model.cariUniverse
import org.d3if3041.universerthings.network.UpdateWorker
import java.util.concurrent.TimeUnit

class MainViewModel (private val db: UniverseDao) : ViewModel() {
    private val hasilUniverse = MutableLiveData<HasilUniverse?>()

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
    fun getHasilUniverse(): LiveData<HasilUniverse?> = hasilUniverse

    fun scheduleUpdater(app: Application) {
        val request = OneTimeWorkRequestBuilder<UpdateWorker>()
            .setInitialDelay(1, TimeUnit.MINUTES)
            .build()
        WorkManager.getInstance(app).enqueueUniqueWork(
            MainActivity.CHANNEL_ID,
            ExistingWorkPolicy.REPLACE,
            request
        )
    }

}