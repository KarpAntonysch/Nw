package com.example.nw.screens

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.nw.R
import com.example.nw.data.Hit
import com.example.nw.databinding.FragmentMainBinding
import com.example.nw.dialogs.DialogInterface
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainFragment : Fragment(),DialogInterface {
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
        toolbarSettings()
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


    private fun getPicturesByCategory(view: View, q: String) {
        view.setOnClickListener {
            if (viewModel.internetChecking(requireContext())){
                getPictures(q)
            }else{
                showDialog(R.string.attention,R.string.internet,R.string.ok,childFragmentManager)
            }
        }
    }


    private fun getPictures(q: String) {
        viewModel.getPathCategory(requireContext(),q).observe(viewLifecycleOwner) {
            val bundleForImageFragment = Bundle()
            val bundleHits: ArrayList<Hit> = ArrayList(it.hits)
            bundleForImageFragment.putParcelableArrayList("ArgForImageFrag: com.example.nw.data.Hit",
                bundleHits)
            if (bundleHits.isNullOrEmpty()){
                Toast.makeText(context, R.string.incorrect_request, Toast.LENGTH_SHORT).show()
            }else{
                lifecycleScope.launch {
                    delay(1000)// что бы успел отработать postValue в фоновом потоке
                    findNavController().navigate(R.id.action_mainFragment_to_imageFragment,
                        bundleForImageFragment)
                }
            }
        }
    }

    private fun toolbarSettings(){
        val toolbar=binding.mainToolBar
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.title = requireActivity().getString(R.string.category)
    }
}
