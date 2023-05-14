package org.d3if3041.universerthings.ui.histori

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if3041.universerthings.data.UniverseDao

class HistoriViewModel(private val db: UniverseDao) : ViewModel() {
    val data = db.getLastUniverse()
    fun hapusData() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            db.clearData()
        }
    }
}