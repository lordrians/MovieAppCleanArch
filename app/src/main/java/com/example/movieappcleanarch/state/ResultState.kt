package com.example.movieappcleanarch.state

sealed class ResultState<out R>{
    data class Success<out T>(val data: T): ResultState<T>()
    data class Error(val errorMessage: String): ResultState<Nothing>()
    object InProgress: ResultState<Nothing>()
    object Done: ResultState<Nothing>()
}
