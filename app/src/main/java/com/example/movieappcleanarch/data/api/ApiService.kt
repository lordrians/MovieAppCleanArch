package com.example.movieappcleanarch.data.api

import com.example.movieappcleanarch.data.remote.ResponseMovie
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET

interface ApiService {
    @GET("popular")
    fun getAllMovie(): Flowable<ResponseMovie>
}