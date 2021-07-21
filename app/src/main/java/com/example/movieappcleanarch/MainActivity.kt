package com.example.movieappcleanarch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.movieappcleanarch.presentation.MainViewModel
import com.example.movieappcleanarch.state.ResultState
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.movies.observe(this,{
            when (it){
                is ResultState.InProgress -> {}
                is ResultState.Success -> {
                    Log.i("ActivityMain", "onCreate: ${it.data}")
                }
                is ResultState.Done -> {}
                is ResultState.Error -> {}
            }
        })

    }

}