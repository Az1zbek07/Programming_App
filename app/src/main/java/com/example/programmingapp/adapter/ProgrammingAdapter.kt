package com.example.programmingapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.programmingapp.databinding.ProgrammingLayoutBinding
import com.example.programmingapp.model.Button
import com.example.programmingapp.model.Programming
import com.example.programmingapp.util.Constants

class ProgrammingAdapter(private val context: Context): ListAdapter<Programming, ProgrammingAdapter.RvViewHolder>(DiffCallBack()) {
    lateinit var onClick: (Programming) -> Unit
    private class DiffCallBack: DiffUtil.ItemCallback<Programming>(){
        override fun areItemsTheSame(oldItem: Programming, newItem: Programming): Boolean {
            return  oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Programming, newItem: Programming): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
        return RvViewHolder(ProgrammingLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class RvViewHolder(private val binding: ProgrammingLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(programming: Programming){
            val adapter = ButtonAdapter()
            binding.rv.adapter = adapter
            binding.rv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter.submitList(Constants.buttonsReturn())
            binding.lessonName.text = programming.name
            binding.textGo.setOnClickListener {
                onClick(programming)
            }
        }
    }
}