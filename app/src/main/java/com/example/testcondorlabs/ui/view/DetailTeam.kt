package com.example.testcondorlabs.ui.view

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testcondorlabs.data.model.EventsModel
import com.example.testcondorlabs.data.model.TeamModel
import com.example.testcondorlabs.databinding.ActivityDetailTeamBinding
import com.example.testcondorlabs.ui.EventAdapter
import com.example.testcondorlabs.ui.viewmodel.EventViewModel
import com.squareup.picasso.Picasso

class DetailTeam : AppCompatActivity() {

    private lateinit var binding: ActivityDetailTeamBinding
    private lateinit var adapter: EventAdapter
    private var eventsObserver = EventsModel(mutableListOf())
    private val eventViewModel: EventViewModel by viewModels()
    private lateinit var uriInstagram: Uri
    private lateinit var uriFacebook: Uri
    private lateinit var uriTwitter: Uri
    private lateinit var uriWebPage: Uri

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
            uriInstagram = Uri.parse("http://" + teamSelect.instagramTeam)
            uriFacebook = Uri.parse("https://" + teamSelect.facebookTeam)
            uriTwitter = Uri.parse("https://" + teamSelect.twitterTeam)
            uriWebPage = Uri.parse("https://" + teamSelect.websiteTeam)
            eventViewModel.onCreate(teamSelect.idTeam.toInt())
            eventViewModel.eventModel.observe(this, {
                eventsObserver = it
                initRecyclerView()
            })
        }

        binding.ivWebPage.setOnClickListener {
            this.startActivity(
                Intent(Intent.ACTION_VIEW, uriWebPage)
            )
        }

        binding.ivInstagram.setOnClickListener {
            this.startActivity(
                Intent(Intent.ACTION_VIEW, uriInstagram)
            )
        }

        binding.ivFacebook.setOnClickListener {
            this.startActivity(
                Intent(Intent.ACTION_VIEW, uriFacebook)
            )
        }

        binding.ivTwitter.setOnClickListener {
            this.startActivity(
                Intent(Intent.ACTION_VIEW, uriTwitter)
            )
        }
    }

    private fun initRecyclerView() {
        adapter = EventAdapter(eventsObserver.events)
        binding.recyclerEvents.layoutManager = LinearLayoutManager(this)
        binding.recyclerEvents.adapter = adapter
    }
}