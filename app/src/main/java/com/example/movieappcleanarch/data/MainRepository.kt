package com.example.movieappcleanarch.data

import com.example.movieappcleanarch.data.remote.ResultsItem
import com.example.movieappcleanarch.state.ResultState
import io.reactivex.rxjava3.core.Flowable

interface MainRepository {
    fun getAllMovie(): Flowable<ResultState<List<ResultsItem>>>
}