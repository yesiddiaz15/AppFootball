package com.example.testcondorlabs.data.network

import com.example.testcondorlabs.core.RetrofitHelper
import com.example.testcondorlabs.data.model.TeamModel
import com.example.testcondorlabs.data.model.TeamsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TeamService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getTeams(): TeamsModel {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(TeamApiClient::class.java)
                .getAllTeamsForLeague("search_all_teams.php?l=Spanish%20La%20Liga")
            response.body() ?: TeamsModel(mutableListOf())
        }
    }
}