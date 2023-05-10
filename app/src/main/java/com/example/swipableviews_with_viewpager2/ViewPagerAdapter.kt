package com.example.swipableviews_with_viewpager2

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.swipableviews_with_viewpager2.databinding.ActivityMainBinding
import com.example.swipableviews_with_viewpager2.databinding.ItemViewPagerBinding

class ViewPagerAdapter(
    val image: List<Int>
) :RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>(){
    inner class ViewPagerViewHolder(val binding: ItemViewPagerBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemViewPagerBinding.inflate(layoutInflater,parent,false)
        return ViewPagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {

        val curImage = image[position]
        holder.binding.ivImage.setImageResource(curImage)
    }

    override fun getItemCount(): Int {
        return image.size
    }
}