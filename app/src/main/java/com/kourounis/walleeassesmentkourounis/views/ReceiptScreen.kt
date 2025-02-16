package com.kourounis.walleeassesmentkourounis.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kourounis.walleeassesmentkourounis.data.models.Amount
import com.kourounis.walleeassesmentkourounis.data.models.Receipt
import com.kourounis.walleeassesmentkourounis.data.models.TransactionDetails
import com.kourounis.walleeassesmentkourounis.ui.theme.WalleeAssesmentKourounisTheme
import com.kourounis.walleeassesmentkourounis.view.models.ReceiptViewModel
import com.kourounis.walleeassesmentkourounis.views.components.Loader
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@Composable
fun ReceiptScreen(
    viewModel: ReceiptViewModel
) {
    val receipt by viewModel.receipt.collectAsStateWithLifecycle()

    ReceiptContentLoader(
        receipt = receipt,
    )
}

@Composable
private fun ReceiptContentLoader(
    receipt: Receipt? = null,
) {
    Loader(loading = receipt == null) {
        if (receipt != null) {
            ReceiptContent(
                receipt = receipt,
            )
        }

    }
}

@Composable
fun ReceiptContent(receipt: Receipt) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.White, shape = RoundedCornerShape(8.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("RECEIPT", fontWeight = FontWeight.Bold, fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))


        ReceiptRow("Transaction ID:", receipt.transactionId)
        ReceiptRow("Date:", formatTimestamp(receipt.transactionDetails.timestamp))
        ReceiptRow("Status:", receipt.status)
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))


        ReceiptRow("Currency:", receipt.amount.currency)
        ReceiptRow("Purchase Amount:", receipt.amount.purchaseAmount)
        ReceiptRow("Taxable Amount:", receipt.amount.taxableAmount)
        ReceiptRow("Tax Rate:", receipt.amount.taxRate)
        ReceiptRow("Tip Amount:", receipt.amount.tipAmount)
        ReceiptRow("Discount:", receipt.amount.discountAmount)
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))


        Text(
            "Total: ${receipt.amount.purchaseAmount}",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text("Thank you for your purchase!", fontSize = 14.sp)
    }
}

@Composable
fun ReceiptRow(label: String, value: String) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(label)
        Text(value, fontWeight = FontWeight.Bold)
    }
}

private fun formatTimestamp(timestamp: String): String {
    return try {
        val zonedDateTime = ZonedDateTime.parse(timestamp)
        zonedDateTime.format(DateTimeFormatter.ofPattern("MMM dd, yyyy hh:mm a"))
    } catch (e: Exception) {
        timestamp
    }
}


@Preview(showBackground = true)
@Composable
fun ReceiptContentPreview() {
    WalleeAssesmentKourounisTheme {
        ReceiptContent(
            receipt = Receipt(
                amount = Amount(
                    currency = "EUR",
                    discountAmount = "5.00",
                    purchaseAmount = "50.00",
                    taxRate = "10",
                    taxableAmount = "45.00",
                    tipAmount = "2.00"
                ),
                status = "Completed",
                transactionDetails = TransactionDetails(timestamp = "2025-02-16 14:30:00"),
                transactionId = "123456789"
            )
        )
    }

}

