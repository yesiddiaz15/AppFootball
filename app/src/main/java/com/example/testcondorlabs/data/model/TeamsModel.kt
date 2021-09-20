package com.example.testcondorlabs.data.model

import com.google.gson.annotations.SerializedName

data class TeamsModel(
    @SerializedName("teams") val teams: MutableList<TeamModel>
)