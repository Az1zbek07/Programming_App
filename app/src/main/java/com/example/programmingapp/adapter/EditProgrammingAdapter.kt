package com.example.programmingapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.programmingapp.database.EditProgrammingDatabase
import com.example.programmingapp.databinding.EditProgrammingLayoutBinding
import com.example.programmingapp.model.EditProgramming
import com.example.programmingapp.util.toBitmap

class EditProgrammingAdapter(private val context: Context): ListAdapter<EditProgramming, EditProgrammingAdapter.RvViewHolder>(DiffCallBack()) {
    lateinit var onEdit: (EditProgramming) -> Unit
    private class DiffCallBack: DiffUtil.ItemCallback<EditProgramming>(){
        override fun areItemsTheSame(oldItem: EditProgramming, newItem: EditProgramming): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: EditProgramming,
            newItem: EditProgramming
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
        return RvViewHolder(EditProgrammingLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class RvViewHolder(private val binding: EditProgrammingLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(editProgramming: EditProgramming){
            val db = EditProgrammingDatabase(context = context)
            binding.imageView.setImageBitmap(editProgramming.img.toBitmap())
            binding.textName.text = editProgramming.name
            binding.btnDelete.setOnClickListener{
                db.dao.deleteClub(editProgramming)
            }
            binding.btnEdit.setOnClickListener{
                onEdit(editProgramming)
            }
        }
    }
}