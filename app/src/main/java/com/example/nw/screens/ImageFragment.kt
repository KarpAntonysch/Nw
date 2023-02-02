package com.example.nw.screens

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.nw.R
import com.example.nw.RecyclerViewAdapter
import com.example.nw.data.Hit
import com.example.nw.databinding.FragmentImageBinding

class ImageFragment : Fragment(),AdapterCallBack {
    private lateinit var binding: FragmentImageBinding
    private val adapter = RecyclerViewAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentImageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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

    override fun onClickToWallPaper(picture: Hit) {
        findNavController().navigate(R.id.action_imageFragment_to_fullScreenFragment)
    }

}