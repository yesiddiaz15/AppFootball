package com.example.testcondorlabs.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TeamModel(
    @SerializedName("idTeam") val idTeam: String,
    @SerializedName("strTeam") val nameTeam: String,
    @SerializedName("strDescriptionEN") val descriptionTeam: String,
    @SerializedName("intFormedYear") val formedYearTeam: String,
    @SerializedName("strStadium") val stadiumTeam: String,
    @SerializedName("strTeamBadge") val badgeTeam: String,
    @SerializedName("strTeamJersey") val jerseyTeam: String,
    @SerializedName("strWebsite") val websiteTeam: String,
    @SerializedName("strFacebook") val facebookTeam: String,
    @SerializedName("strTwitter") val twitterTeam: String,
    @SerializedName("strInstagram") val instagramTeam: String
) : Serializable