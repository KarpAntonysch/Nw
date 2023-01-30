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
        getSpacePictures()
        getSciencePictures()
        getCarsPictures()
        getAnimalsPictures()
        getFashionPictures()
        getNaturePictures()
        getGamePictures()
    }

    private fun getFoodPictures() {
        binding.btnFood.setOnClickListener {
            viewModel.getPathCategory("api/?key=33106230-b104905cd7ff74ed17e2229af&q=fastfood&image_type=photo")
            Log.d("MyLog", "Retrofit: ${
                viewModel.getPathCategory("api/?key=33106230-b104905cd7ff74ed17e2229af&q=fastfood&image_type=photo")
            }")
            findNavController().navigate(R.id.action_mainFragment_to_imageFragment)
        }
    }
    private fun getCarsPictures() {
        binding.btnCars.setOnClickListener {
            viewModel.getPathCategory("api/?key=33106230-b104905cd7ff74ed17e2229af&q=cars&image_type=photo")
            Log.d("MyLog", "Retrofit: ${
                viewModel.getPathCategory("api/?key=33106230-b104905cd7ff74ed17e2229af&q=cars&image_type=photo")
            }")
            findNavController().navigate(R.id.action_mainFragment_to_imageFragment)
        }
    }
    private fun getFashionPictures() {
        binding.btnFashion.setOnClickListener {
            viewModel.getPathCategory("api/?key=33106230-b104905cd7ff74ed17e2229af&q=fashion&image_type=photo")
            Log.d("MyLog", "Retrofit: ${
                viewModel.getPathCategory("api/?key=33106230-b104905cd7ff74ed17e2229af&q=fashion&image_type=photo")
            }")
            findNavController().navigate(R.id.action_mainFragment_to_imageFragment)
        }
    }
    private fun getAnimalsPictures() {
        binding.btnAnimals.setOnClickListener {
            viewModel.getPathCategory("api/?key=33106230-b104905cd7ff74ed17e2229af&q=animals&image_type=photo")
            Log.d("MyLog", "Retrofit: ${
                viewModel.getPathCategory("api/?key=33106230-b104905cd7ff74ed17e2229af&q=animals&image_type=photo")
            }")
            findNavController().navigate(R.id.action_mainFragment_to_imageFragment)
        }
    }
    private fun getGamePictures() {
        binding.btnGames.setOnClickListener {
            viewModel.getPathCategory("api/?key=33106230-b104905cd7ff74ed17e2229af&q=games&image_type=photo")
            Log.d("MyLog", "Retrofit: ${
                viewModel.getPathCategory("api/?key=33106230-b104905cd7ff74ed17e2229af&q=games&image_type=photo")
            }")
            findNavController().navigate(R.id.action_mainFragment_to_imageFragment)
        }
    }
    private fun getNaturePictures() {
        binding.btnNature.setOnClickListener {
            viewModel.getPathCategory("api/?key=33106230-b104905cd7ff74ed17e2229af&q=nature&image_type=photo")
            Log.d("MyLog", "Retrofit: ${
                viewModel.getPathCategory("api/?key=33106230-b104905cd7ff74ed17e2229af&q=nature&image_type=photo")
            }")
            findNavController().navigate(R.id.action_mainFragment_to_imageFragment)
        }
    }
    private fun getSciencePictures() {
        binding.btnScince.setOnClickListener {
            viewModel.getPathCategory("api/?key=33106230-b104905cd7ff74ed17e2229af&q=science&image_type=photo")
            Log.d("MyLog", "Retrofit: ${
                viewModel.getPathCategory("api/?key=33106230-b104905cd7ff74ed17e2229af&q=science&image_type=photo")
            }")
            findNavController().navigate(R.id.action_mainFragment_to_imageFragment)
        }
    }
    private fun getSpacePictures() {
        binding.btnSpace.setOnClickListener {
            viewModel.getPathCategory("api/?key=33106230-b104905cd7ff74ed17e2229af&q=space&image_type=photo")
            Log.d("MyLog", "Retrofit: ${
                viewModel.getPathCategory("api/?key=33106230-b104905cd7ff74ed17e2229af&q=space&image_type=photo")
            }")
            findNavController().navigate(R.id.action_mainFragment_to_imageFragment)
        }
    }
}