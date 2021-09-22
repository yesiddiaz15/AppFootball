package com.example.testcondorlabs.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testcondorlabs.databinding.ActivityMainBinding
import com.example.testcondorlabs.ui.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapterTabs = ViewPagerAdapter(supportFragmentManager, lifecycle)
        binding.viewPager.adapter = adapterTabs

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Spanish League"
                1 -> tab.text = "Premier League"
                2 -> tab.text = "French League"
            }
        }.attach()
    }
}