package com.example.testcondorlabs.data.network

import com.example.testcondorlabs.data.model.TeamModel
import com.example.testcondorlabs.data.model.TeamsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface TeamApiClient {
    @GET
    suspend fun getAllTeamsForLeague(@Url url: String) : Response<TeamsModel>
}