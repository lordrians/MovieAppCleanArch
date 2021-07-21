package com.example.movieappcleanarch.di

import com.example.movieappcleanarch.data.MainRepository
import com.example.movieappcleanarch.data.MainRepositoryImpl
import com.example.movieappcleanarch.data.api.ApiService
import com.example.movieappcleanarch.domain.MainUseCase
import com.example.movieappcleanarch.domain.MainUseCaseImpl
import com.example.movieappcleanarch.presentation.MainViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit


val networkModule = module {

    single {
        OkHttpClient.Builder().addInterceptor(
            HttpLoggingInterceptor().setLevel(
                HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(20L, TimeUnit.SECONDS)
            .writeTimeout(30L, TimeUnit.SECONDS)
            .readTimeout(20L, TimeUnit.SECONDS)
            .build()
    }
    single {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }
    single {
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/movie/")
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .client(get())
            .build()
    }
}

val repositoryModule = module {
    single {
        val retrofit: Retrofit = get()
        retrofit.create(ApiService::class.java)
    }
    single<MainRepository> {
        MainRepositoryImpl(get())
    }
}
val mainUseCaseModule = module {
    single<MainUseCase> {
        MainUseCaseImpl(get())
    }
}
val mainViewModelModule = module {
    viewModel {
        MainViewModel(get())
    }
}

