package com.example.macos.data.network

import com.example.macos.domain.models.Card
import retrofit2.Response
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET

interface NetworkApi {

    @GET("/v1/c145c7af-b1ea-42f3-ae85-f6fabe6793c1")
    suspend fun getCards(): Response<MutableList<Card>>
}