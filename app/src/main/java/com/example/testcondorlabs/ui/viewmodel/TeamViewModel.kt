package com.example.testcondorlabs.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testcondorlabs.data.model.TeamModel
import com.example.testcondorlabs.data.model.TeamsModel
import com.example.testcondorlabs.domain.GetTeamsUseCase
import kotlinx.coroutines.launch

class TeamViewModel : ViewModel() {

    val teamModel = MutableLiveData<TeamsModel>()

    var getTeamsUseCase = GetTeamsUseCase()

    fun onCreate(){
        viewModelScope.launch {
            val result = getTeamsUseCase()
            if (result.teams.isNotEmpty()){
                teamModel.postValue(result)
            }
        }
    }
}