package berk.lovecalculator.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import berk.lovecalculator.model.ResultResponse
import berk.lovecalculator.repository.ResultRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResultViewModel
@Inject constructor(private val resultRepository: ResultRepository) : ViewModel() {

    private val _getResultLiveData = MutableLiveData<ResultResponse>()
    val getResultLiveData: LiveData<ResultResponse>
        get() = _getResultLiveData

    fun getResult(yourName: String, partnerName: String) {
        viewModelScope.launch {
            val response = resultRepository.getResult(yourName, partnerName)
            _getResultLiveData.postValue(response)
        }
    }
}