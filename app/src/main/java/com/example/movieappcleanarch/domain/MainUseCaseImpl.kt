package com.example.movieappcleanarch.domain

import com.example.movieappcleanarch.data.MainRepository
import com.example.movieappcleanarch.data.remote.ResultsItem
import com.example.movieappcleanarch.state.ResultState
import io.reactivex.rxjava3.core.Flowable

class MainUseCaseImpl constructor(
    private val repository: MainRepository
): MainUseCase {
    override fun getAllMovie(): Flowable<ResultState<List<ResultsItem>>> {
        return repository.getAllMovie()
    }
}