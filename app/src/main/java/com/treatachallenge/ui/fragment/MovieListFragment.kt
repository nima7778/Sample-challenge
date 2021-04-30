package com.treatachallenge.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.treatachallenge.R
import com.treatachallenge.databinding.FragmentMovieListBinding
import com.treatachallenge.ui.adapter.MovieLoadStateAdapter
import com.treatachallenge.ui.adapter.MoviesAdapter
import com.treatachallenge.ui.viewModel.GetMoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieListFragment : Fragment(R.layout.fragment_movie_list),
    MoviesAdapter.onItemClickListener {
    private val viewModel by viewModels<GetMoviesViewModel>()
    private var _binding: FragmentMovieListBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMovieListBinding.bind(view)


        val adapter = MoviesAdapter(this , requireContext())
        binding.apply {
            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.adapter = adapter
            recyclerView.adapter = adapter.withLoadStateHeaderAndFooter(
                header = MovieLoadStateAdapter{adapter.retry()},
                footer = MovieLoadStateAdapter{adapter.retry()}
            )
        }
        viewModel.movies.observe(viewLifecycleOwner) {
            adapter.submitData(viewLifecycleOwner.lifecycle, it)

        }

        adapter.addLoadStateListener { loadState ->
            binding.apply {
                progressBar.isVisible = loadState.source.refresh is LoadState.Loading
                recyclerView.isVisible = loadState.source.refresh is LoadState.NotLoading
                buttonRetry.isVisible = loadState.source.refresh is LoadState.Error
                textViewError.isVisible = loadState.source.refresh is LoadState.Error

                // No result
                if (loadState.source.refresh is LoadState.NotLoading &&
                    loadState.append.endOfPaginationReached &&
                    adapter.itemCount < 1
                ) {

                    recyclerView.isVisible = false
                    textViewEmpty.isVisible = true

                } else {
                    textViewEmpty.isVisible = false
                }

            }
        }

    }

    override fun onItemClick(contentId: Long) {
        val bundle= Bundle()
        bundle.putLong("contentId" ,contentId)
        findNavController().navigate(R.id.action_mainPageFragment_to_detailOfMovieFragment , bundle)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}