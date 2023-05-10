package com.example.swipableviews_with_viewpager2

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.swipableviews_with_viewpager2.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val images = listOf(
            R.drawable.spaceship,
            R.drawable.kermit,
            R.drawable.watch,
            R.drawable.ic_launcher_foreground
        )

        val adapter = ViewPagerAdapter(images)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout,binding.viewPager){ tab, position->
            tab.text = "Tab ${position +1}"
        }.attach()

        binding.tabLayout.addOnTabSelectedListener(object :OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity,"Selected ${tab?.text}",Toast.LENGTH_SHORT).show()

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity,"UnSelected ${tab?.text}",Toast.LENGTH_SHORT).show()

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity,"Reselected ${tab?.text}",Toast.LENGTH_SHORT).show()
            }
        })

//        //Swipe Vertical
//        binding.viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL
//
//        //Swipe automate
//        val page = binding.viewPager
//        page.beginFakeDrag()
//        page.fakeDragBy(-5f)
//        page.endFakeDrag()
    }
}