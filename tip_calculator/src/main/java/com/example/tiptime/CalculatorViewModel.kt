package com.example.tiptime

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.text.NumberFormat

class CalculatorViewModel : ViewModel() {
    var billAmount by mutableStateOf("")
        private set

    var tipAmount by mutableStateOf(ZERO_TIP)
        private set

    fun changeBillAmount(newAmount: String) {
        try {
            val amount = newAmount.toDouble()
            tipAmount = calculateTip(amount)
            billAmount = newAmount
        } catch (_: NumberFormatException) {
            when (newAmount) {
                "" -> {
                    tipAmount = ZERO_TIP
                    billAmount = newAmount
                }

                "d" -> return
            }
        }
    }

    private fun calculateTip(amount: Double, tipPercent: Double = 15.0): String {
        val tip = tipPercent / 100 * amount
        return NumberFormat.getCurrencyInstance().format(tip)
    }

}

private const val ZERO_TIP = "0.00"
