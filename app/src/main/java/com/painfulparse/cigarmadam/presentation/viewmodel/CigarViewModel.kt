package com.painfulparse.cigarmadam.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.painfulparse.cigarmadam.domain.model.Cigar
import com.painfulparse.cigarmadam.domain.usecases.base.UseCaseProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CigarViewModel @Inject constructor(
    private val useCaseProvider: UseCaseProvider
) : ViewModel() {

    private val _cigars = MutableStateFlow<List<Cigar>>(emptyList())
    val cigars: StateFlow<List<Cigar>> = _cigars

    init {
        fetchCigars()
    }

    private fun fetchCigars() {
        viewModelScope.launch {
            _cigars.value = useCaseProvider.getAllCigars.invoke()
        }
    }

    private fun deleteCigar(cigar: Cigar) {
        viewModelScope.launch {
            useCaseProvider.deleteCigar.invoke(cigar)
        }
    }

    private fun addCigar(cigar: Cigar) {
        viewModelScope.launch {
            useCaseProvider.addCigar(cigar)
        }
    }
}