package com.example.tiptime

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.text.NumberFormat

class CalculatorViewModel : ViewModel() {

    var billAmount by mutableStateOf("")
        private set

    var tipPercentage by mutableStateOf("")
        private set

    var tipAmount by mutableStateOf(ZERO_TIP)
        private set

    fun changeBillAmount(newAmount: String) {
        try {
            val amount = newAmount.toDouble()
            billAmount = newAmount
            tipAmount = calculateTip(amount = amount)
        } catch (_: NumberFormatException) {
            if (newAmount.isBlank()) {
                billAmount = newAmount
                tipAmount = ZERO_TIP
            }
        }
    }

    fun changeTipPercentage(newPercentage: String) {
        try {
            val percentage = newPercentage.toDouble()
            tipPercentage = newPercentage
            tipAmount = calculateTip(tipPercent = percentage)
        } catch (_: NumberFormatException) {
            if (newPercentage.isBlank()) {
                tipPercentage = newPercentage
                tipAmount = calculateTip()
            }
        }
    }

    private fun calculateTip(
        amount: Double = billAmount.toDoubleOrNull() ?: 0.0,
        tipPercent: Double = this.tipPercentage.toDoubleOrNull() ?: DEFAULT_TIP_PERCENT,
    ): String {
        val tip = tipPercent / 100 * amount
        return NumberFormat.getCurrencyInstance().format(tip)
    }
}

private const val ZERO_TIP = "0.00"
private const val DEFAULT_TIP_PERCENT = 15.0
