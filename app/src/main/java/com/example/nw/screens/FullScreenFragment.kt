package com.example.nw.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.nw.R
import com.example.nw.databinding.FragmentFullScreenBinding


class FullScreenFragment : Fragment() {
    private lateinit var binding: FragmentFullScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentFullScreenBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showWallPaper(getWallPaperPicture())
    }

    private fun getWallPaperPicture():String?{
        return arguments?.getString("ArgForWallPaper: string")
    }

    private fun showWallPaper(url:String?){
        Glide
            .with(requireContext())
            .load(url)
            .centerCrop()
            .into(binding.imageView)
    }
}