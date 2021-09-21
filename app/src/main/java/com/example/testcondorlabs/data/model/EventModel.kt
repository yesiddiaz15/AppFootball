package com.example.testcondorlabs.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class EventModel(
    @SerializedName("strEvent") val event: String,
    @SerializedName("intHomeScore") val homeScore: String,
    @SerializedName("intAwayScore") val awayScore: String,
    @SerializedName("strLeague") val leagueEvent: String,
    @SerializedName("dateEvent") val dateEvent: String,
    @SerializedName("strTime") val timeEvent: String,
    @SerializedName("strVenue") val venueEvent: String,
    @SerializedName("strStatus") val statusEvent: String
) : Serializable
