package com.example.programmingapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.programmingapp.databinding.FragmentLessonsListBinding
import com.example.programmingapp.databinding.LessonLayoutBinding
import com.example.programmingapp.model.Lesson

class LessonAdapter: ListAdapter<Lesson, LessonAdapter.RvViewHolder>(DiffCallBack()) {
    lateinit var onClick: (Lesson) -> Unit
    private class DiffCallBack: DiffUtil.ItemCallback<Lesson>(){
        override fun areItemsTheSame(oldItem: Lesson, newItem: Lesson): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Lesson, newItem: Lesson): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
        return RvViewHolder(LessonLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class RvViewHolder(private val binding: LessonLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(lesson: Lesson){
            binding.lessonName.text = lesson.name
            binding.numberLessons.text = lesson.numberOfLessons.toString()
            itemView.setOnClickListener {
                onClick(lesson)
            }
        }
    }
}