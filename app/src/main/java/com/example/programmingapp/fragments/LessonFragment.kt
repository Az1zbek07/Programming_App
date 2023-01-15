package com.example.programmingapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.programmingapp.R
import com.example.programmingapp.databinding.FragmentButtonsBinding
import com.example.programmingapp.databinding.FragmentLessonBinding
import com.example.programmingapp.model.ButtonLesson
import com.example.programmingapp.model.Lesson

class LessonFragment : Fragment(R.layout.fragment_lesson) {
    private var _binding: FragmentLessonBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentLessonBinding.bind(view)
        val buttonLesson = arguments?.getParcelable<ButtonLesson>("buttonLesson")!!
        binding.numberLesson.text = buttonLesson.numberLesson.toString()
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}