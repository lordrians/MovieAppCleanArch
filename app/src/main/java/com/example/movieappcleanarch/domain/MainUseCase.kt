package com.example.movieappcleanarch.domain

import com.example.movieappcleanarch.data.remote.ResultsItem
import com.example.movieappcleanarch.state.ResultState
import io.reactivex.rxjava3.core.Flowable

interface MainUseCase {
    fun getAllMovie(): Flowable<ResultState<List<ResultsItem>>>
}