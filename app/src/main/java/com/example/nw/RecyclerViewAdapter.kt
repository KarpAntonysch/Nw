package com.example.nw


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nw.data.Hit
import com.example.nw.databinding.PictureItemBinding
import com.example.nw.screens.AdapterCallBack

class RecyclerViewAdapter(val callBack: AdapterCallBack) :
    ListAdapter<Hit, RecyclerViewAdapter.PictureViewHolder>(BankingComparator()) {

    class PictureViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = PictureItemBinding.bind(view)
        fun bind(picture: Hit,callBack: AdapterCallBack) = with(binding) {
            // использую контекст из кнопки
            Glide
                .with(imageButton.context)
                .load(picture.webformatURL)
                .centerCrop()
                .placeholder(R.drawable.ic_loading)
                .into(binding.imageButton)
            binding.imageButton.setOnClickListener {
                callBack.onClickToWallPaper(picture)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.picture_item, parent, false)
        return PictureViewHolder(view)
    }

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        val currentPicture = getItem(position)
        holder.bind(currentPicture,callBack)
    }

    class BankingComparator : DiffUtil.ItemCallback<Hit>() {
        override fun areItemsTheSame(oldItem: Hit, newItem: Hit): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Hit, newItem: Hit): Boolean {
            return oldItem == newItem
        }
    }
}