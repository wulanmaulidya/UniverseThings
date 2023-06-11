package org.d3if3041.universerthings.ui.listdata

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if3041.universerthings.model.Universe
import org.d3if3041.universerthings.network.ApiStatus
import org.d3if3041.universerthings.network.UniverseApi

class ListDataViewModel : ViewModel() {
    private val data = MutableLiveData<List<Universe>>()
    private val status = MutableLiveData<ApiStatus>()
    init {
        retrieveData()
    }
    private fun retrieveData() {
        viewModelScope.launch (Dispatchers.IO) {
            status.postValue(ApiStatus.LOADING)
            try {
                data.postValue(UniverseApi.service.getUniverse())
                status.postValue(ApiStatus.SUCCESS)
            } catch (e: Exception) {
                Log.d("ListdataViewModel", "Failure: ${e.message}")
                status.postValue(ApiStatus.FAILED)

            }
        }
    }
    fun getData(): LiveData<List<Universe>> = data
    fun getStatus(): LiveData<ApiStatus> = status
}