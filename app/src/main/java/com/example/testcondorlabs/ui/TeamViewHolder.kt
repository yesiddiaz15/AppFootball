package com.example.testcondorlabs.ui

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.testcondorlabs.data.model.TeamModel
import com.example.testcondorlabs.databinding.ItemTeamBinding
import com.squareup.picasso.Picasso

class TeamViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemTeamBinding.bind(view)

    fun bind(team: TeamModel) {
        Picasso.get().load(team.badgeTeam).into(binding.bridgeTeam)
        binding.nameTeam.text = team.nameTeam
        binding.stadiumTeam.text = team.stadiumTeam
    }

}
