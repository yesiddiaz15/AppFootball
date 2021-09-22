package com.example.testcondorlabs.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.testcondorlabs.R
import com.example.testcondorlabs.data.model.TeamsModel
import com.example.testcondorlabs.databinding.FragmentFrenchLeagueBinding
import com.example.testcondorlabs.databinding.FragmentPremierLeagueBinding
import com.example.testcondorlabs.ui.adapter.TeamAdapter
import com.example.testcondorlabs.ui.viewmodel.TeamViewModel

class FrenchLeagueFragment : Fragment() {

    private var _binding : FragmentFrenchLeagueBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: TeamAdapter
    private var teamsObserver = TeamsModel(mutableListOf())
    private val teamViewModel: TeamViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFrenchLeagueBinding.inflate(inflater, container, false)
        initRecyclerView()

        teamViewModel.onCreate("French%20Ligue%201")

        teamViewModel.teamModel.observe(viewLifecycleOwner, {
            teamsObserver = it
            initRecyclerView()
        })
        return binding.root
    }

    private fun initRecyclerView(){
        adapter = TeamAdapter(requireActivity(), teamsObserver.teams)
        binding.recyclerTeamsFrench.layoutManager = GridLayoutManager(requireActivity(), 2)
        binding.recyclerTeamsFrench.adapter = adapter
    }
}