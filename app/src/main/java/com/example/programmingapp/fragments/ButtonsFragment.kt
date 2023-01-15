package com.example.programmingapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.programmingapp.R
import com.example.programmingapp.adapter.ButtonLessonAdapter
import com.example.programmingapp.databinding.FragmentButtonsBinding
import com.example.programmingapp.databinding.FragmentLessonsListBinding
import com.example.programmingapp.model.Lesson
import com.example.programmingapp.util.Constants

class ButtonsFragment : Fragment(R.layout.fragment_buttons) {
    private var _binding: FragmentButtonsBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentButtonsBinding.bind(view)
        val adapter = ButtonLessonAdapter()
        binding.rv.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.rv.adapter = adapter
        adapter.submitList(Constants.buttonLessonReturn())
        adapter.onClick = {
            val bundle = bundleOf("buttonLesson" to it)
            findNavController().navigate(R.id.action_buttonsFragment_to_lessonFragment, bundle)
        }

        val lesson = arguments?.getParcelable<Lesson>("lesson")!!
        binding.lessonName.text = lesson.name
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}