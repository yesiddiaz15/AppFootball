package com.example.testcondorlabs.ui.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testcondorlabs.data.model.TeamModel
import com.example.testcondorlabs.databinding.ActivityDetailTeamBinding
import com.example.testcondorlabs.databinding.ActivityMainBinding
import com.example.testcondorlabs.databinding.ItemTeamBinding
import com.squareup.picasso.Picasso

class DetailTeam : AppCompatActivity() {

    private lateinit var binding: ActivityDetailTeamBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent != null && intent.extras?.get("team") != null) {
            val teamSelect = intent.extras?.get("team") as TeamModel
            Picasso.get().load(teamSelect.jerseyTeam).into(binding.jerseyTeam)
            Picasso.get().load(teamSelect.badgeTeam).into(binding.badgeTeam)
            binding.teamName.text = teamSelect.nameTeam
            binding.teamDescription.text = teamSelect.descriptionTeam
            binding.foundationTeam.text = "(${teamSelect.formedYearTeam})"
        }
    }
}