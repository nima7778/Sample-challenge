package com.treatachallenge.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.treatachallenge.R
import com.treatachallenge.databinding.FragmentFavoriteMovieBinding
import com.treatachallenge.ui.adapter.FavoritesAdapter
import com.treatachallenge.ui.viewModel.GetMoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteMovieFragment : Fragment(R.layout.fragment_favorite_movie),
    FavoritesAdapter.ClickListener {
    private var _binding: FragmentFavoriteMovieBinding ? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<GetMoviesViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFavoriteMovieBinding.bind(view)
        setRecyclerview()

    }

    private fun setRecyclerview(){
        val  adapter = FavoritesAdapter(requireContext() , this)
        binding.apply {
            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.adapter = adapter
        }
        viewModel.getAllFavorites()
        viewModel.getFavoritesLiveData?.observe(viewLifecycleOwner , Observer {
            adapter.submitList(it)
        })

    }

    override fun listener(contentId: Long) {
        val bundle= Bundle()
        bundle.putLong("contentId" ,contentId)
        findNavController().navigate(R.id.action_mainPageFragment_to_detailOfMovieFragment , bundle)
    }

}