package com.example.nw.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nw.databinding.FragmentFullScreenBinding


class FullScreenFragment : Fragment() {
    private lateinit var binding: FragmentFullScreenBinding
    private val fullScreenViewModel = FullScreenViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentFullScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fullScreenViewModel.showWallPaper(requireContext(),
            getWallPaperPicture(),
            binding.imageView)

        fullScreenViewModel.setWallPaper(requireContext(), getWallPaperPicture())

    }


    private fun getWallPaperPicture(): String? {
        return arguments?.getString("ArgForWallPaper: string")
    }

}