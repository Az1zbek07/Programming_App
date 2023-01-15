package com.example.programmingapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.programmingapp.databinding.ButtonLayoutBinding
import com.example.programmingapp.model.Button

class ButtonAdapter: ListAdapter<Button, ButtonAdapter.RvViewHolder>(DiffCallBack()) {
    private class DiffCallBack: DiffUtil.ItemCallback<Button>() {
        override fun areItemsTheSame(oldItem: Button, newItem: Button): Boolean {
            return newItem.names == oldItem.names
        }

        override fun areContentsTheSame(oldItem: Button, newItem: Button): Boolean {
            return newItem == oldItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
        return RvViewHolder(ButtonLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class RvViewHolder(private val binding: ButtonLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(button: Button){
            binding.btnName.text = button.names
        }
    }
}