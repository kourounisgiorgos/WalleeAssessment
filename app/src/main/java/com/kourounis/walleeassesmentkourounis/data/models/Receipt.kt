package com.kourounis.walleeassesmentkourounis.data.models

data class Receipt(
    val amount: Amount,
    val status: String,
    val transactionDetails: TransactionDetails,
    val transactionId: String
)

data class TransactionDetails(
    val timestamp: String
)

data class Amount(
    val currency: String,
    val discountAmount: String,
    val purchaseAmount: String,
    val taxRate: String,
    val taxableAmount: String,
    val tipAmount: String
)