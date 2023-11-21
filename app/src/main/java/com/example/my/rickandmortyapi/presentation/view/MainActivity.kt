package com.example.my.rickandmortyapi.presentation.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.my.rickandmortyapi.databinding.ActivityMainBinding
import com.example.my.rickandmortyapi.presentation.adapter.RickAndMortyAdapter
import com.example.my.rickandmortyapi.presentation.viewmodel.RickAndMortyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterMain: RickAndMortyAdapter
    private val viewModelMain: RickAndMortyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapterMain = RickAndMortyAdapter()

        binding.recyclerView.apply {
            adapter = adapterMain
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            setHasFixedSize(true)
        }

        lifecycleScope.launchWhenCreated {
            viewModelMain.state.collect {
                when {
                    it.load -> binding.progressBar.visibility = View.VISIBLE
                    it.success.isNotEmpty() -> {
                        binding.progressBar.visibility = View.GONE
                        adapterMain.submitList(it.success)
                    }

                    it.fail.isNotBlank() -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(this@MainActivity, it.fail, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

}