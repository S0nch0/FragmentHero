package com.example.fragmenthero.api

import com.example.fragmenthero.data.Superhero
import io.reactivex.Single
import retrofit2.http.GET

interface ApiInterface {
    @GET("superhero-api/api/all.json")
    fun getSuperheroes(): Single<List<Superhero>>
}