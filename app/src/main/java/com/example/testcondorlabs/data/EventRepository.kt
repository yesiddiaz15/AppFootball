package com.example.testcondorlabs.data

import com.example.testcondorlabs.data.model.EventProvider
import com.example.testcondorlabs.data.model.EventsModel
import com.example.testcondorlabs.data.network.EventService

class EventRepository {
    private val api = EventService()

    suspend fun getEvents(idTeam: Int): EventsModel {
        val response = api.getEvents(idTeam)
        EventProvider.events = response
        return response
    }
}