package com.example.testcondorlabs.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testcondorlabs.data.model.EventsModel
import com.example.testcondorlabs.domain.GetEventsUseCase
import kotlinx.coroutines.launch

class EventViewModel : ViewModel() {
    val eventModel = MutableLiveData<EventsModel>()

    var getEventsUseCase = GetEventsUseCase()

    fun onCreate(idTeam: Int){
        viewModelScope.launch {
            val result = getEventsUseCase(idTeam)
            if (result.events.isNotEmpty()){
                eventModel.postValue(result)
            }
        }
    }
}