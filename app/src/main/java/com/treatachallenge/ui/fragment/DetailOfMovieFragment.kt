package com.treatachallenge.ui.fragment

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.google.android.material.appbar.AppBarLayout
import com.treatachallenge.R
import com.treatachallenge.data.local.MovieEntity
import com.treatachallenge.databinding.FragmentDetailOfMovieBinding
import com.treatachallenge.ui.model.detail.DetailRequestBody
import com.treatachallenge.ui.model.detail.Request
import com.treatachallenge.ui.viewModel.GetMoviesViewModel
import com.treatachallenge.utils.CommonUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailOfMovieFragment : Fragment(R.layout.fragment_detail_of_movie),
    AppBarLayout.OnOffsetChangedListener {
    private var _binding: FragmentDetailOfMovieBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<GetMoviesViewModel>()
    private var progressDialog: ProgressDialog? = null
    private var _movieEntity: MovieEntity? = null
    private val movieEntity get() = _movieEntity!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentDetailOfMovieBinding.bind(view)
        setBack()
        addToFavorite()
        val id: Long? = arguments?.getLong("contentId")
        viewModel.getDetail(DetailRequestBody(Request(id)))
        viewModel.apply {
            detailLiveData.observe(viewLifecycleOwner, Observer {
                Glide.with(requireContext())
                    .load(it.result.landscapeImage)
                    .placeholder(R.drawable.ic_loading)
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .error(R.drawable.ic_baseline_error_24)
                    .into(binding.collapsingImage)
                binding.collapsingToolbar.title = it.result.title
                binding.txtSummary.text = it.result.summary
                _movieEntity = MovieEntity(
                    it.result.contentID,
                    it.result.thumbImage,
                    it.result.title,
                    it.result.zoneID
                )
                isFavorite()

            })
            detailMutableLiveData.observe(viewLifecycleOwner, Observer {
                if (it.equals("loading")) {
                    progressDialog = CommonUtils.loadingDialog(requireContext())
                    progressDialog!!.show()
                } else if (it.equals("error")) {
                    progressDialog?.dismiss()
                    Toast.makeText(
                        requireContext(),
                        "error happened. try later.",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    progressDialog?.dismiss()
                }
            })
        }

        binding.appBar.addOnOffsetChangedListener(this)

    }

    private fun setBack() {
        binding.backspace.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun isFavorite() {
        viewModel.getCurrentMovie(movieEntity.contentId)
        viewModel.getMovieLiveData?.observe(viewLifecycleOwner, Observer {
            if (it == null) {
                binding.favorite.setChecked(false)
            } else {
                binding.favorite.setChecked(true)
            }
        })
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun addToFavorite() {
        binding.favorite.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                try {
                    viewModel.insertMovie(movieEntity)
                } catch (e: NullPointerException) {
                    Toast.makeText(requireContext() , "error happened. try later." , Toast.LENGTH_SHORT).show()
                }
                val animation = AnimationUtils.loadAnimation(context, R.anim.bounce_in)
                Handler(Looper.getMainLooper()).postDelayed({
                }, 800)
                binding.favorite.startAnimation(animation)
                binding.favorite.setBackground(requireContext().resources.getDrawable(R.drawable.ic_baseline_favorite_24))
            } else {
                try {
                    viewModel.removeFromFavorite(movieEntity.contentId)
                } catch (e: NullPointerException) {
                    Toast.makeText(requireContext() , "error happened. try later." , Toast.LENGTH_SHORT).show()
                }
                val animation = AnimationUtils.loadAnimation(context, R.anim.bounce_out)
                binding.favorite.startAnimation(animation)
                binding.favorite.setBackground(requireContext().resources.getDrawable(R.drawable.ic_baseline_favorite_border_24))
            }
        }
    }

    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        if (verticalOffset == 0) {
            binding.toolbar.setBackgroundColor(requireContext().resources.getColor(R.color.clear_white))
        } else if (Math.abs(verticalOffset) == appBarLayout?.getTotalScrollRange()) {
            binding.toolbar.setBackgroundColor(requireContext().resources.getColor(R.color.white))
        } else {
            binding.toolbar.setBackgroundColor(requireContext().resources.getColor(R.color.clear_white))

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}