package com.example.testcondorlabs.data

import com.example.testcondorlabs.data.model.TeamProvider
import com.example.testcondorlabs.data.model.TeamsModel
import com.example.testcondorlabs.data.network.TeamService

class TeamRepository {

    private val api = TeamService()

    suspend fun getAllTeams(nameLeague: String): TeamsModel {
        val response = api.getTeams(nameLeague)
        TeamProvider.teams = response
        return response
    }
}