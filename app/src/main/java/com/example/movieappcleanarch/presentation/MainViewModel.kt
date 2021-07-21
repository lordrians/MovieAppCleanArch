package com.example.movieappcleanarch.presentation

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.example.movieappcleanarch.domain.MainUseCase


class MainViewModel constructor(
    private val mainUseCase: MainUseCase
) : ViewModel(){

    val movies = LiveDataReactiveStreams.fromPublisher(mainUseCase.getAllMovie())

}