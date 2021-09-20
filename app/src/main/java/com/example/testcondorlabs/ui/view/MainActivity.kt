package com.example.testcondorlabs.ui.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.testcondorlabs.data.model.TeamModel
import com.example.testcondorlabs.data.model.TeamsModel
import com.example.testcondorlabs.databinding.ActivityMainBinding
import com.example.testcondorlabs.ui.TeamAdapter
import com.example.testcondorlabs.ui.viewmodel.TeamViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: TeamAdapter
    private var teamsObserver = TeamsModel(mutableListOf())

    private val teamViewModel: TeamViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()

        teamViewModel.onCreate()

        teamViewModel.teamModel.observe(this, {
            teamsObserver = it
            initRecyclerView()
        })
    }

    private fun initRecyclerView() {
        adapter = TeamAdapter(this, teamsObserver.teams)
        binding.recyclerTeams.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerTeams.adapter = adapter
    }
}