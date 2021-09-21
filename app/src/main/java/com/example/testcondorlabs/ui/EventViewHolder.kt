package com.example.testcondorlabs.ui

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.testcondorlabs.data.model.EventModel
import com.example.testcondorlabs.data.model.TeamModel
import com.example.testcondorlabs.databinding.ItemEventBinding
import com.squareup.picasso.Picasso

class EventViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemEventBinding.bind(view)

    @SuppressLint("SetTextI18n")
    fun bind(event: EventModel) {
        binding.nameEvent.text = event.event
        binding.scoreBoardEvent.text = "${event.homeScore}        -       ${event.awayScore}"
        binding.dateEvent.text = "${event.dateEvent} ${event.timeEvent}"
        binding.leagueEvent.text = event.leagueEvent
        binding.venueEvent.text = event.venueEvent
        binding.statusEvent.text = event.statusEvent
    }
}