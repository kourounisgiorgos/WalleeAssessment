package com.kourounis.walleeassesmentkourounis.view.models

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kourounis.walleeassesmentkourounis.data.models.Receipt
import com.kourounis.walleeassesmentkourounis.repository.ReceiptRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReceiptViewModel @Inject constructor(
    private val repository: ReceiptRepository,
) : ViewModel() {

    data class UiState(
        val loading: Boolean = false,
        val error: Boolean = false,
    )

    val state = MutableStateFlow(UiState())
    val receipt = MutableStateFlow<Receipt?>(null)

    fun fetchReceipt(onReceipt: () -> Unit) {

        state.update { it.copy(loading = true) }

        viewModelScope.launch {

            val response = repository.getReceipt()

            if (response.isSuccessful) {
                receipt.value = response.body()
                onReceipt.invoke()
            } else {
                state.update { it.copy(error = true) }
            }

            state.update { it.copy(loading = false, error = false) }
        }
    }

}