package com.example.programmingapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.programmingapp.R
import com.example.programmingapp.adapter.ProgrammingAdapter
import com.example.programmingapp.databinding.FragmentProgrammingListBinding
import com.example.programmingapp.util.Constants

class ProgrammingList : Fragment(R.layout.fragment_programming_list) {
    private var _binding: FragmentProgrammingListBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentProgrammingListBinding.bind(view)
        val adapter = ProgrammingAdapter(requireContext())
        binding.rv.layoutManager = LinearLayoutManager(requireContext())
        binding.rv.adapter = adapter
        adapter.submitList(Constants.programmingReturn())

        adapter.onClick = {
            val bundle = bundleOf("programming" to it)
            findNavController().navigate(R.id.action_programmingList_to_lessonsListFragment, bundle)
        }
        binding.btnSettings.setOnClickListener {
            findNavController().navigate(R.id.action_programmingList_to_settingsFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}