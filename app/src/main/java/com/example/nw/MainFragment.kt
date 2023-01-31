package com.example.nw

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.nw.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val viewModel = MainFragmentViewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getFoodPictures()

    }

    private fun getFoodPictures() {
        binding.btnFood.setOnClickListener {
            viewModel.getPathCategory("33106230-b104905cd7ff74ed17e2229af","fastfood","photo")
            findNavController().navigate(R.id.action_mainFragment_to_imageFragment)
        }
    }

}