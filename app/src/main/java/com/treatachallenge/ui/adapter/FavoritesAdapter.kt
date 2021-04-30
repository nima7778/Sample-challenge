package com.treatachallenge.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.treatachallenge.R
import com.treatachallenge.data.local.MovieEntity
import com.treatachallenge.databinding.ItemMovieBinding

class FavoritesAdapter(private val context: Context , private val clickListener: ClickListener) :
    ListAdapter<MovieEntity, FavoritesAdapter.MyViewHolder>(DiffCallback()) {

    inner class MyViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener(View.OnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val item = getItem(position)
                    if (item != null) {
                        clickListener.listener(item.contentId)
                    }
                }
            })
        }

        fun bind(movieEntity: MovieEntity) {
            binding.apply {
                Glide.with(itemView)
                    .load(movieEntity.image)
                    .placeholder(R.drawable.ic_loading)
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .error(R.drawable.ic_baseline_error_24)
                    .into(movieImage)
                movieName.text = movieEntity.title
                if (movieEntity.type == 3) {
                    movieType.text = context.getString(R.string.serial)

                } else if (movieEntity.type == 4) {
                    movieType.text = context.getString(R.string.cinematic)
                }

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind((currentItem))
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<MovieEntity>() {
        override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean =
            oldItem.contentId == newItem.contentId
        override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean =
            oldItem == newItem
    }
    interface ClickListener{
        fun listener(contentId: Long)
    }
}