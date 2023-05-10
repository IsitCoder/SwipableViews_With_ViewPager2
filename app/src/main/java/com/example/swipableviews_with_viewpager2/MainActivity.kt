package com.example.swipableviews_with_viewpager2

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.swipableviews_with_viewpager2.databinding.ActivityMainBinding

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

        //Swipe Vertical
        binding.viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL

        //Swipe automate
        val page = binding.viewPager
        page.beginFakeDrag()
        page.fakeDragBy(-5f)
        page.endFakeDrag()
    }
}