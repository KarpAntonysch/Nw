package com.example.nw.screens

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.nw.R
import com.example.nw.data.Hit
import com.example.nw.databinding.FragmentMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


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
        getPicturesByCategory(binding.btnAnimals, "animals")
        getPicturesByCategory(binding.btnCars, "cars")
        getPicturesByCategory(binding.btnFashion, "fashion")
        getPicturesByCategory(binding.btnFood, "food")
        getPicturesByCategory(binding.btnScince, "science")
        getPicturesByCategory(binding.btnSpace, "space+sky")
        getPicturesByCategory(binding.btnGames, "pc+games")
        getPicturesByCategory(binding.btnNature, "nature")
    }

    private fun getPicturesByCategory(d: View, q: String) {
        d.setOnClickListener {
            getPictures(q)
        }
    }


    private fun getPictures(q: String) {
        viewModel.getPathCategory(q).observe(viewLifecycleOwner) {
            Log.d("MyLog", "VM1:${it}}")
            val bundleForImageFragment = Bundle()
            val bundleHits: ArrayList<Hit?> = ArrayList(it.hits!!)
            bundleForImageFragment.putParcelableArrayList("ArgForImageFrag: com.example.nw.data.Hit",
                bundleHits)
            lifecycleScope.launch {
                delay(1000)// что бы успел отработать postValue в фоновом потоке
                findNavController().navigate(R.id.action_mainFragment_to_imageFragment,
                    bundleForImageFragment)
            }
        }
    }
}