package com.example.testcondorlabs.domain

import com.example.testcondorlabs.data.TeamRepository
import com.example.testcondorlabs.data.model.TeamsModel

class GetTeamsUseCase {

    private val repository = TeamRepository()

    suspend operator fun invoke(nameLeague: String): TeamsModel = repository.getAllTeams(nameLeague)
}