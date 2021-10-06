package com.ambrella.retrofitgsonexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.forEach as forEach1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.movies_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        // Вызываем метод getTopRatedMovies()
        val call = MovieApiClient.apiClient.getTopRatedMovies(API_KEY, "ru")
        call.enqueue(object : Callback<MoviesResponse> {
            override fun onResponse(
                call: Call<MoviesResponse>,
                response: Response<MoviesResponse>
            ) {
                val movies = response.body()!!.results
                // Передаем результат в adapter и отображаем элементы
                recyclerView.adapter = MoviesAdapter(movies, R.layout.list_item_movie)
            }
            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                // Log error here since request failed
                Log.e(TAG, t.toString())
            }
        })
    }
    companion object {
        private val TAG = MainActivity::class.java.simpleName
        // TODO - insert your themoviedb.org API KEY here
        private val API_KEY = "59a202c94eb1db326c806558399d7d75"
    }
}