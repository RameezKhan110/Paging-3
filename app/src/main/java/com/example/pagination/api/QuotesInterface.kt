package com.example.pagination.api

import com.example.pagination.model.Quotes
import com.example.pagination.utils.Constants
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesInterface {

    @GET("quotes?")
    suspend fun getQuotes(@Query("page") page: Int): Quotes
}
object QuotesService {

    val quotesInterface: QuotesInterface

    init {
        val retrofit = Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        ).build()
        quotesInterface = retrofit.create()
    }
}