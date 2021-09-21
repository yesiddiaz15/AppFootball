package com.example.testcondorlabs.data.model

import com.google.gson.annotations.SerializedName

data class EventsModel(
    @SerializedName("results") val events: MutableList<EventModel>
)
