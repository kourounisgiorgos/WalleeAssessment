package com.kourounis.walleeassesmentkourounis.data.api

import com.kourounis.walleeassesmentkourounis.data.models.Receipt
import retrofit2.Response
import retrofit2.http.GET

interface ReceiptService {

    @GET("/")
    suspend fun getReceipt(): Response<Receipt>

}