package com.example.testcondorlabs.ui.view

import android.os.Bundle
import android.view.View
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

        refreshMain()

        binding.btnRetry.setOnClickListener {
            refreshMain()
        }
    }

    private fun refreshMain(){
        if(isOnlineNet()){
            binding.linearMain.visibility = View.VISIBLE
            binding.relativeRetry.visibility = View.GONE
            TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
                when (position) {
                    0 -> tab.text = "Spanish League"
                    1 -> tab.text = "Premier League"
                    2 -> tab.text = "French League"
                }
            }.attach()
        }else{
            binding.linearMain.visibility = View.GONE
            binding.relativeRetry.visibility = View.VISIBLE
        }
    }

    private fun isOnlineNet(): Boolean {
        try {
            val process: Process = Runtime.getRuntime().exec("ping -c 1 www.google.es")
            val int = process.waitFor()
            return (int == 0);

        } catch (e: Exception) {
            e.printStackTrace();
        }
        return false;
    }
}