package com.example.programmingapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.programmingapp.R
import com.example.programmingapp.adapter.EditProgrammingAdapter
import com.example.programmingapp.database.EditProgrammingDatabase
import com.example.programmingapp.databinding.FragmentLessonBinding
import com.example.programmingapp.databinding.FragmentSettingsBinding
import com.example.programmingapp.model.EditProgramming
import com.example.programmingapp.util.toByteArray

class SettingsFragment : Fragment(R.layout.fragment_settings) {
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    private val db by lazy { EditProgrammingDatabase(requireContext()) }
    private val adapter by lazy { EditProgrammingAdapter(requireContext()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSettingsBinding.bind(view)

        binding.rv.layoutManager = LinearLayoutManager(requireContext())
        binding.rv.adapter = adapter
        adapter.submitList(db.dao.getAllClubs())
        adapter.onEdit = {
            val bundle = bundleOf("data" to it)
            findNavController().navigate(R.id.action_settingsFragment_to_editFragment, bundle)
        }

        binding.editImage.setOnClickListener {
            binding.editImage.setBackgroundResource(0)
            imageLauncher.launch("image/*")
        }

        binding.btnAdd.setOnClickListener {
            val name = binding.editName.text.toString().trim()
            val image = binding.editImage

            if (name.isNotBlank()){
                val editProgramming = EditProgramming(name = name, img = image.toByteArray())
                db.dao.saveClub(editProgramming)
                Toast.makeText(requireContext(), "Saved", Toast.LENGTH_SHORT).show()
                findNavController().popBackStack()
            }else{
                Toast.makeText(requireContext(), "Please enter name", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private val imageLauncher = registerForActivityResult(ActivityResultContracts.GetContent()){
        it?.let { uri ->
            binding.editImage.setImageURI(uri)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}