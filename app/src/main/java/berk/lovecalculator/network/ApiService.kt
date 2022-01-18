package berk.lovecalculator.network

import berk.lovecalculator.model.ResultResponse
import berk.lovecalculator.util.Constants.API_KEY
import berk.lovecalculator.util.Constants.ENDPOINT
import berk.lovecalculator.util.Constants.HOST
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    @Headers("x-rapidapi-key: $API_KEY", "x-rapidapi-host: $HOST")
    @GET(ENDPOINT)
    suspend fun getResult(
        @Query("fname") yourName: String,
        @Query("sname") partnerName: String
    ): ResultResponse
}