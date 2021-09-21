package com.example.testcondorlabs.data.network

import com.example.testcondorlabs.data.model.EventsModel
import com.example.testcondorlabs.data.model.TeamsModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class EventServiceTest {

    @Test
    fun getInformation() = runBlocking {
        var eventService = EventService()
        val events: EventsModel
        coroutineScope {
            events = eventService.getEvents(133602)
        }
        Assert.assertNotNull(events)
    }

    @Test(timeout = 1500)
    fun getInformationTimeout() = runBlocking {
        var eventService = EventService()
        val events: EventsModel
        coroutineScope {
            events = eventService.getEvents(133602)
        }
        Assert.assertNotNull(events)
    }
}