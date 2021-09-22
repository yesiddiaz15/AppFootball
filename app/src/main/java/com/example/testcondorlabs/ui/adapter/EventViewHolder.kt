package com.example.testcondorlabs.ui.adapter

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
        binding.homeTeam.text = event.homeTeam
        binding.awayTeam.text = event.awayTeam
        binding.homeScore.text = event.homeScore
        binding.awayScore.text = event.awayScore
        binding.dateEvent.text = event.dateEvent
        binding.stateEvent.text = event.statusEvent
        binding.timeEvent.text = event.timeEvent
    }
}