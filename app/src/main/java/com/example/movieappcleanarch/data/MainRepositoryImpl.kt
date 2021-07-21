package com.example.movieappcleanarch.data

import android.util.Log
import com.example.movieappcleanarch.data.api.ApiService
import com.example.movieappcleanarch.data.remote.ResultsItem
import com.example.movieappcleanarch.state.ResultState
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject

class MainRepositoryImpl constructor(
    private val apiService: ApiService
) : MainRepository{

    override fun getAllMovie(): Flowable<ResultState<List<ResultsItem>>> {
        val resultData = PublishSubject.create<ResultState<List<ResultsItem>>>()

        //get data from remote api
        val client = apiService.getAllMovie()

        client
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .take(1)
            .subscribe({ response ->
                val dataArray = response.results
                resultData.onNext(if (dataArray.isNotEmpty()) ResultState.Success(dataArray) else ResultState.Done)
            }, { error ->
                resultData.onNext(ResultState.Error(error.message.toString()))
                Log.e("MainRespository", error.toString())
            })

        return resultData.toFlowable(BackpressureStrategy.BUFFER)
    }


}