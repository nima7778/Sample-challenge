package com.treatachallenge.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.treatachallenge.R
import com.treatachallenge.databinding.ItemMovieBinding
import com.treatachallenge.ui.model.detail.DetailRequestBody
import com.treatachallenge.ui.model.list.GetContent

class MoviesAdapter(private val clickListener: onItemClickListener , private val context: Context) :
    PagingDataAdapter<GetContent, MoviesAdapter.MoviesViewHolder>(
        MovieDiffCallback
    ) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind((currentItem))
        }
    }


    interface onItemClickListener {
        fun onItemClick(contentId: Long)
    }

    inner class MoviesViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val item = getItem(position)
                    if (item != null) {
                        clickListener.onItemClick(item.contentID)
                    }
                }
            }
        }

        fun bind(content: GetContent) {
            binding.apply {
                Glide.with(itemView)
                    .load(content.thumbImage)
                    .placeholder(R.drawable.ic_loading)
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .error(R.drawable.ic_baseline_error_24)
                    .into(movieImage)
                movieName.text = content.title
                if (content.zoneID == 3) {
                    movieType.text = context.getString(R.string.serial)

                } else if (content.zoneID == 4) {
                    movieType.text = context.getString(R.string.cinematic)
                }
            }

        }

    }

    companion object {
        private val MovieDiffCallback = object : DiffUtil.ItemCallback<GetContent>() {
            override fun areItemsTheSame(oldItem: GetContent, newItem: GetContent) =
                oldItem.contentID == newItem.contentID

            override fun areContentsTheSame(
                oldItem: GetContent,
                newItem: GetContent
            ) = oldItem == newItem
        }
    }
}