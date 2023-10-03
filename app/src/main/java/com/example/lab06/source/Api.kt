package com.example.lab06.source

import retrofit2.http.GET

interface TeleportApi {
    @GET("urban_areas/")
    suspend fun getCities(): List<City>
}

data class City(val slug: String, val name: String)