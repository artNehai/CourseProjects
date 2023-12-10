package com.example.tiptime

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.text.NumberFormat
import kotlin.math.ceil

class CalculatorViewModel : ViewModel() {

    var billAmount by mutableStateOf("")
        private set

    var tipPercent by mutableStateOf("")
        private set

    var tipAmount by mutableStateOf(ZERO_TIP)
        private set

    var roundUp by mutableStateOf(false)
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
            tipPercent = newPercentage
            tipAmount = calculateTip(tipPercent = percentage)
        } catch (_: NumberFormatException) {
            if (newPercentage.isBlank()) {
                tipPercent = newPercentage
                tipAmount = calculateTip()
            }
        }
    }

    fun onRoundUpChange(newValue: Boolean) {
        roundUp = newValue
        tipAmount = calculateTip()
    }

    private fun calculateTip(
        amount: Double = billAmount.toDoubleOrNull() ?: 0.0,
        tipPercent: Double = this.tipPercent.toDoubleOrNull() ?: DEFAULT_TIP_PERCENT,
        roundUp: Boolean = this.roundUp,
    ): String {
        var tip = tipPercent / 100 * amount
        if (roundUp) {
            tip = ceil(tip)
        }
        return NumberFormat.getCurrencyInstance().format(tip)
    }
}

private const val ZERO_TIP = "0.00"
private const val DEFAULT_TIP_PERCENT = 15.0
