package com.example.testcondorlabs.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.testcondorlabs.ui.view.FrenchLeagueFragment
import com.example.testcondorlabs.ui.view.PremierLeagueFragment
import com.example.testcondorlabs.ui.view.SpanishLeagueFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                SpanishLeagueFragment()
            }
            1 -> {
                PremierLeagueFragment()
            }
            2 -> {
                FrenchLeagueFragment()
            }
            else -> {
                Fragment()
            }
        }
    }
}