package berk.lovecalculator.repository

import berk.lovecalculator.network.ApiService
import javax.inject.Inject

class ResultRepository
@Inject constructor(private val apiService: ApiService) {
    suspend fun getResult(yourName: String, partnerName: String) =
        apiService.getResult(yourName, partnerName)
}