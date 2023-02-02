package com.example.nw.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

}