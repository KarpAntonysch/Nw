package com.example.nw.screens

import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.nw.RecyclerViewAdapter
import com.example.nw.data.Hit
import com.example.nw.databinding.FragmentImageBinding

class ImageFragment : Fragment() {
    private lateinit var binding: FragmentImageBinding
    val viewModel = ImageFragmentViewModel()
    private val adapter = RecyclerViewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentImageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //showImage(gettingHitsFromMF()?.get(1)?.webformatURL.toString())
        realizationOfRV()

    }

    private fun realizationOfRV(){
        val recyclerView = binding.rvImage
        recyclerView.layoutManager = GridLayoutManager(requireContext(),2)
        recyclerView.adapter = adapter
        adapter.submitList(gettingHitsFromMF())
    }

    // Изменил работу в связи с измененим устаревшего метода получения parcelable типов в андроид выше тирамиссу
    private fun gettingHitsFromMF(): List<Hit?>? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getParcelableArrayList("ArgForImageFrag: com.example.nw.data.Hit",
                Hit::class.java)
        } else {
            @Suppress("DEPRECATION")
            arguments?.getParcelableArrayList("ArgForImageFrag: com.example.nw.data.Hit")
        }
    }
}