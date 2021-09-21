package com.example.testcondorlabs.data.network

import com.example.testcondorlabs.core.RetrofitHelper
import com.example.testcondorlabs.data.model.EventsModel
import com.example.testcondorlabs.data.model.TeamsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class EventService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getEvents(idTeam: Int): EventsModel {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(EventApiClient::class.java)
                .getFiveLastEvents("eventslast.php?id=$idTeam")
            response.body() ?: EventsModel(mutableListOf())
        }
    }
}