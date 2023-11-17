package com.painfulparse.cigarmadam.feature_cigars.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.painfulparse.cigarmadam.feature_cigars.domain.model.Cigar
import com.painfulparse.cigarmadam.feature_cigars.domain.usecases.CigarUseCases
import com.painfulparse.cigarmadam.feature_cigars.domain.util.CigarOrder
import com.painfulparse.cigarmadam.feature_cigars.domain.util.OrderType
import com.painfulparse.cigarmadam.feature_cigars.presentation.cigars.CigarEvent
import com.painfulparse.cigarmadam.feature_cigars.presentation.state.CigarInventoryState
import com.painfulparse.cigarmadam.feature_cigars.presentation.state.CigarUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CigarViewModel @Inject constructor(
    private val cigarUseCases: CigarUseCases
) : ViewModel() {

    private val _uiState = mutableStateOf<CigarUiState>(CigarUiState.Loading)
    private val _state = mutableStateOf(CigarInventoryState())
    val state: State<CigarInventoryState> = _state
    val cigarUiState: State<CigarUiState> = _uiState

    private var getAllCigarsJob: Job? = null
    private var addCigarJob: Job? = null
    private var recentlyDeletedCigar: Cigar? = null

    init {
        fetchCigars(CigarOrder.Date(OrderType.Descending))
    }

    fun onEvent(cigarEvent: CigarEvent) {
        when (cigarEvent) {
            is CigarEvent.DeleteCigar -> TODO()
            is CigarEvent.Order -> TODO()
            is CigarEvent.RestoreCigar -> TODO()
            is CigarEvent.ToggleOrderSection -> TODO()
            is CigarEvent.AddCigar -> addCigar(cigarEvent.cigar)
        }
    }

    private fun fetchCigars(cigarOrder: CigarOrder) {
        getAllCigarsJob?.cancel()
        getAllCigarsJob = cigarUseCases.getAllCigars(cigarOrder)
            .onEach { cigars ->
                _state.value = state.value.copy(
                    cigars = cigars,
                    cigarOrder = cigarOrder
                )
            }
            .launchIn(viewModelScope)
    }

    private fun addCigar(cigar: Cigar) {
        addCigarJob?.cancel()
        addCigarJob = viewModelScope.launch {
            _uiState.value = CigarUiState.Saving
            try {
                cigarUseCases.addCigar(cigar)
                fetchCigars(state.value.cigarOrder)
                _uiState.value = CigarUiState.Saving
            } catch (e: Exception) {
                _uiState.value = CigarUiState.Error(e.message ?: "Unknown Error")
            }
        }
    }
}

