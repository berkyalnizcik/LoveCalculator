package berk.lovecalculator.model

import com.google.gson.annotations.SerializedName

data class ResultResponse(
    @SerializedName("fname")
    val yourName: String,
    @SerializedName("sname")
    val partnerName: String,
    val percentage: String,
    val result: String
)