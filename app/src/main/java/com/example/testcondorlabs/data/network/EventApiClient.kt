package com.example.testcondorlabs.data.network

import com.example.testcondorlabs.data.model.EventsModel
import com.example.testcondorlabs.data.model.TeamsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface EventApiClient {
    @GET
    suspend fun getFiveLastEvents(@Url url: String) : Response<EventsModel>
}