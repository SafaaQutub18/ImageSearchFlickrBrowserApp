package com.safaa.flickrbrowserapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.safaa.flickrbrowserapp.databinding.RowRecyclerviewBinding


class RecyclerViewAdapter(val mainActivity: MainActivity) : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {
    class RecyclerViewHolder(val binding: RowRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root)

    var photosList: List<PhotoX> = ArrayList()

    fun setphotoList(photoArrayList: List<PhotoX>) {
        this.photosList = photoArrayList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(RowRecyclerviewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {

        var currentPhoto = photosList[position]
        holder.binding.apply {
            cardLayout.setBackgroundResource(R.drawable.custom_button);
            titleTv.text = currentPhoto.title
            Glide.with(mainActivity)
                .load(currentPhoto.url_h)
                .override(280,180)
                .into(imageV)
            cardLayout.setOnClickListener { mainActivity.openPhoto(currentPhoto.url_h) }

        }
    }
    override fun getItemCount() = photosList.size

}
