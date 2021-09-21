package com.example.testcondorlabs.domain

import com.example.testcondorlabs.data.EventRepository
import com.example.testcondorlabs.data.model.EventsModel

class GetEventsUseCase() {

    private val repository = EventRepository()

    suspend operator fun invoke(idTeam: Int): EventsModel = repository.getEvents(idTeam)
}