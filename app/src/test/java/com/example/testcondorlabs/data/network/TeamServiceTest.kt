package com.example.testcondorlabs.data.network

import com.example.testcondorlabs.data.model.TeamsModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

@ExperimentalCoroutinesApi
class TeamServiceTest {

    @Test
    fun getInformation() = runBlocking {
        var teamService = TeamService()
        val teams: TeamsModel
        coroutineScope {
            teams = teamService.getTeams()
        }
        Assert.assertNotNull(teams)
    }

    @Test(timeout = 1500)
    fun getInformationTimeout() = runBlocking {
        var teamService = TeamService()
        val teams: TeamsModel
        coroutineScope {
            teams = teamService.getTeams()
        }
        Assert.assertNotNull(teams)
    }
}