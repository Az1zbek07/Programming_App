package com.example.programmingapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.programmingapp.R
import com.example.programmingapp.adapter.LessonAdapter
import com.example.programmingapp.databinding.FragmentLessonsListBinding
import com.example.programmingapp.databinding.FragmentProgrammingListBinding
import com.example.programmingapp.model.Programming
import com.example.programmingapp.util.Constants

class LessonsListFragment : Fragment(R.layout.fragment_lessons_list) {
    private var _binding: FragmentLessonsListBinding? = null
    private val binding get() = _binding!!
    private lateinit var programming: Programming

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        programming = arguments?.getParcelable<Programming>("programming")!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentLessonsListBinding.bind(view)

        binding.programmingName.text = programming.name
        val adapter = LessonAdapter()
        binding.rv.layoutManager = LinearLayoutManager(requireContext())
        binding.rv.adapter = adapter
        adapter.submitList(Constants.lessonsReturn())
        adapter.onClick = {
            val bundle = bundleOf("lesson" to it)
            findNavController().navigate(R.id.action_lessonsListFragment_to_buttonsFragment, bundle)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}