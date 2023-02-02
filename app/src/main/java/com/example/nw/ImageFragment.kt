package com.example.nw

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.nw.data.Hit
import com.example.nw.databinding.FragmentImageBinding

class ImageFragment : Fragment() {
    private lateinit var binding: FragmentImageBinding
    val viewModel = ImageFragmentViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentImageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textView.text = gettingHitsFromMF().toString()
        showImage(gettingHitsFromMF()?.get(1)?.webformatURL.toString())
    }
    //TODO проверить работоспособность. Изменил работу в связи с измененим
    // устаревшего метода получения parcelable типов в андроид выше тирамиссу
    private fun gettingHitsFromMF(): List<Hit?>? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getParcelableArrayList("ArgForImageFrag: com.example.nw.data.Hit",
                Hit::class.java)
        } else {
            @Suppress("DEPRECATION")
            arguments?.getParcelableArrayList("ArgForImageFrag: com.example.nw.data.Hit")
        }
    }

    private fun showImage(uri: String) {
        Glide.with(requireContext())
            .load(uri)
            .into(binding.imageView)
    }
}