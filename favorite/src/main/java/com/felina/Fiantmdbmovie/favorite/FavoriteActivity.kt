package com.felina.Fiantmdbmovie.favorite

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.felina.Fiantmdbmovie.core.ui.MovieAdapter
import com.felina.Fiantmdbmovie.detail.DetailMovieActivity

import com.felina.Fiantmdbmovie.favorite.databinding.ActivityFavoriteBinding
import com.felina.Fiantmdbmovie.favorite.di.FavoriteModule
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavoriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavoriteBinding
    private val favoriteViewModel: FavoriteViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadKoinModules(FavoriteModule)
            val movieAdapter = MovieAdapter()
            movieAdapter.onItemClick = { selectedData ->
                val intent = Intent(this, DetailMovieActivity::class.java)
                intent.putExtra(DetailMovieActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            favoriteViewModel.favoriteTourism.observe(this, { dataTourism ->
                movieAdapter.setData(dataTourism)
//                binding.viewEmpty.root.visibility = if (dataTourism.isNotEmpty()) View.GONE else View.VISIBLE
            })

            with(binding.rvTourism) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }

