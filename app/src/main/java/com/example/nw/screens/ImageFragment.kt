package com.example.nw.screens

import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.nw.R
import com.example.nw.adapter.AdapterCallBack
import com.example.nw.adapter.RecyclerViewAdapter
import com.example.nw.data.Hit
import com.example.nw.databinding.FragmentImageBinding

class ImageFragment : Fragment(), AdapterCallBack {
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
        toolbarSettings()
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
        val pictureUrlBundle = Bundle()
        pictureUrlBundle.putString("ArgForWallPaper: string",picture.webformatURL)
        findNavController().navigate(R.id.action_imageFragment_to_fullScreenFragment,pictureUrlBundle)
    }

    private fun toolbarSettings(){
        val toolbar=binding.imageToolBar
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.title = requireActivity().getString(R.string.back)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(true)
        requireActivity().addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu,menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
              if (menuItem.itemId == android.R.id.home){
                  findNavController().navigate(R.id.action_imageFragment_to_mainFragment)
              }
                return true
            }

        },viewLifecycleOwner,Lifecycle.State.RESUMED)
    }

}