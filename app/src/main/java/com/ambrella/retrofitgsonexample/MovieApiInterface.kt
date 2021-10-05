package com.ambrella.retrofitgsonexample

import okhttp3.Call
import retrofit2.http.GET
import retrofit2.http.Query
import com.ambrella.retrofitgsonexample.MoviesResponse

interface MovieApiInterface {
    @GET("movie/top_rated")
    fun getTopRatedMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): retrofit2.Call<MoviesResponse>
}