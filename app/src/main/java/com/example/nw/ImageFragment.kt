package com.example.nw

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nw.data.Hit
import com.example.nw.databinding.FragmentImageBinding

class ImageFragment : Fragment() {
    private lateinit var binding: FragmentImageBinding
    val viewModel = ImageFragmentViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentImageBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textView.text = s().toString()

    }

    fun s():List<Hit?>?{
     return arguments?.getParcelableArrayList("ArgForImageFrag: com.example.nw.data.Hit")
    }
}