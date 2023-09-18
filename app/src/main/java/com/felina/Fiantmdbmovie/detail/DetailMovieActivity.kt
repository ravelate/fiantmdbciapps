package com.felina.Fiantmdbmovie.detail

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.felina.Fiantmdbmovie.R
import com.felina.Fiantmdbmovie.core.data.Resource
import com.felina.Fiantmdbmovie.core.domain.model.Movie
import com.felina.Fiantmdbmovie.core.ui.ReviewAdapter
import com.felina.Fiantmdbmovie.core.ui.VideoAdapter
import com.felina.Fiantmdbmovie.databinding.ActivityDetailMovieBinding
import org.koin.android.viewmodel.ext.android.viewModel

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val detailTourismViewModel: DetailMovieViewModel by viewModel()
    private lateinit var binding: ActivityDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val detailMovie = intent.getParcelableExtra<Movie>(EXTRA_DATA)

        showDetailMovie(detailMovie)
    }

    private fun showDetailMovie(detailMovie: Movie?) {
        detailMovie?.let {
            supportActionBar?.title = detailMovie.title
            binding.content.tvDetailDescription.text = detailMovie.overview
            binding.content.tvDetailReleasedate.text = getString(R.string.text_release).format(detailMovie.releaseDate)
            binding.content.tvDetailRating.text = getString(R.string.text_rating).format(detailMovie.voteAverage.toString())
            Glide.with(this@DetailMovieActivity)
                .load("https://image.tmdb.org/t/p/original/"+detailMovie.posterPath)
                .into(binding.ivDetailImage)

            var statusFavorite = detailMovie.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailTourismViewModel.setFavoriteMovie(detailMovie, statusFavorite)
                setStatusFavorite(statusFavorite)
            }

            val videoAdapter = VideoAdapter()
            val reviewAdapter = ReviewAdapter()
            detailTourismViewModel.getAllVideo(detailMovie.id).observe(this,{ tourism ->
            if (tourism != null) {
                when (tourism) {
                    is Resource.Loading -> binding.content.progressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.content.progressBar.visibility = View.GONE
                        videoAdapter.setData(tourism.data)
                    }
                    is Resource.Error -> {
                        binding.content.progressBar.visibility = View.GONE
                        binding.content.viewError.root.visibility = View.VISIBLE
                        binding.content.viewError.tvError.text = getString(R.string.something_wrong)
                    }
                }
            }
        })
            detailTourismViewModel.getAllReview(detailMovie.id).observe(this,{ tourism ->
                if (tourism != null) {
                    when (tourism) {
                        is Resource.Loading -> {
                            binding.content.progressBarReview.visibility = View.VISIBLE
                            binding.content.tvDetailComment.visibility = View.GONE
                        }
                        is Resource.Success -> {
                            binding.content.progressBarReview.visibility = View.GONE
                            binding.content.tvDetailComment.visibility = View.VISIBLE
                            reviewAdapter.setData(tourism.data)
                        }
                        is Resource.Error -> {
                            binding.content.progressBarReview.visibility = View.GONE
                            binding.content.tvDetailComment.visibility = View.GONE
                            binding.content.viewError.root.visibility = View.VISIBLE
                            binding.content.viewError.tvError.text = getString(R.string.something_wrong)
                        }
                    }
                }
            })

            with(binding.content.rvVideo) {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
                setHasFixedSize(true)
                adapter = videoAdapter
            }
            with(binding.content.rvReview) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = reviewAdapter
            }
            videoAdapter.onItemClick = { selectedData ->
                openYoutubeLink(selectedData.key)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_not_favorite_white))
        }
    }
    private fun openYoutubeLink(youtubeID: String) {
        val intentApp = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + youtubeID))
        val intentBrowser = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + youtubeID))
        try {
            this.startActivity(intentApp)
        } catch (ex: ActivityNotFoundException) {
            this.startActivity(intentBrowser)
        }

    }
}
