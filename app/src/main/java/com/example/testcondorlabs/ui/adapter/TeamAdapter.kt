package com.example.testcondorlabs.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testcondorlabs.R
import com.example.testcondorlabs.data.model.TeamModel
import com.example.testcondorlabs.ui.view.DetailTeam

class TeamAdapter(private var context: Context, private val teams: List<TeamModel>) :
    RecyclerView.Adapter<TeamViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TeamViewHolder(
            layoutInflater.inflate(R.layout.item_team, parent, false)
        ).listen()
    }

    private fun <T : RecyclerView.ViewHolder> T.listen(): T {
        itemView.setOnClickListener {
            context.startActivity(
                Intent(context, DetailTeam::class.java)
                    .putExtra(
                        "team", teams[adapterPosition]
                    )
            )
        }
        return this
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bind(teams[position])
    }

    override fun getItemCount(): Int = teams.size
}