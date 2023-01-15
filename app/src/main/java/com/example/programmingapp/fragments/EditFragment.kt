package com.example.programmingapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import com.example.programmingapp.R
import com.example.programmingapp.database.EditProgrammingDatabase
import com.example.programmingapp.databinding.FragmentEditBinding
import com.example.programmingapp.databinding.FragmentSettingsBinding
import com.example.programmingapp.model.EditProgramming
import com.example.programmingapp.util.toBitmap
import com.example.programmingapp.util.toByteArray

class EditFragment : Fragment(R.layout.fragment_edit) {
    private var _binding: FragmentEditBinding? = null
    private val binding get() = _binding!!
    private val db by lazy { EditProgrammingDatabase(requireContext()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentEditBinding.bind(view)
        val data = arguments?.getParcelable<EditProgramming>("data")!!

        binding.editImage.setImageBitmap(data?.img?.toBitmap())
        binding.textName.text = data?.name
        binding.editName.setText(data?.name)

        binding.editImage.setOnClickListener {
            binding.editImage.setBackgroundResource(0)
            data.img = byteArrayOf()
            imageLauncher.launch("image/*")
        }

        binding.btnAdd.setOnClickListener {
            val name = binding.editName.text.toString().trim()
            val image = binding.editImage
            if (name.isNotBlank()){
                val editProgramming = EditProgramming(id = data.id, name = name, img = image.toByteArray())
                db.dao.updateClub(editProgramming)
                findNavController().popBackStack()
                Toast.makeText(requireContext(), "Updated", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(requireContext(), "Please enter values", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private val imageLauncher = registerForActivityResult(ActivityResultContracts.GetContent()){
        it?.let { uri ->
            binding.editImage.setImageURI(uri)
        }
    }
}