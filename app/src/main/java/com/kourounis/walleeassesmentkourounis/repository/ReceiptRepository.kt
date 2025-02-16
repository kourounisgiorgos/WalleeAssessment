package com.kourounis.walleeassesmentkourounis.repository

import com.kourounis.walleeassesmentkourounis.data.api.ReceiptService
import com.kourounis.walleeassesmentkourounis.data.models.Receipt
import retrofit2.Response
import javax.inject.Inject

class ReceiptRepository @Inject constructor(
    private val receiptService: ReceiptService
) {
    suspend fun getReceipt(): Response<Receipt> {
        return receiptService.getReceipt()
    }
}