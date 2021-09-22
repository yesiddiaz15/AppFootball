package com.example.testcondorlabs.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testcondorlabs.R
import com.example.testcondorlabs.data.model.EventModel

class EventAdapter(private val events: List<EventModel>) :
    RecyclerView.Adapter<EventViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return EventViewHolder(
            layoutInflater.inflate(R.layout.item_event, parent, false)
        )
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(events[position])
    }

    override fun getItemCount(): Int = events.size
}