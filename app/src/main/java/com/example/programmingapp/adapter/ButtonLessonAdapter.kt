package com.example.programmingapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.programmingapp.databinding.FragmentButtonsBinding
import com.example.programmingapp.databinding.NumberLayoutBinding
import com.example.programmingapp.model.ButtonLesson

class ButtonLessonAdapter: ListAdapter<ButtonLesson, ButtonLessonAdapter.RvViewHolder>(DiffCallBack()) {
    lateinit var onClick: (ButtonLesson) -> Unit
    private class DiffCallBack: DiffUtil.ItemCallback<ButtonLesson>(){
        override fun areItemsTheSame(oldItem: ButtonLesson, newItem: ButtonLesson): Boolean {
            return oldItem.numberLesson == newItem.numberLesson
        }

        override fun areContentsTheSame(oldItem: ButtonLesson, newItem: ButtonLesson): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
        return RvViewHolder(NumberLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class RvViewHolder(private val binding: NumberLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(buttonLesson: ButtonLesson){
            binding.number.text = buttonLesson.numberLesson.toString()
            itemView.setOnClickListener {
                onClick(buttonLesson)
            }
        }
    }
}