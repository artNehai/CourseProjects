package com.example.tiptime

import android.icu.text.NumberFormat
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.example.tiptime.ui.theme.TipTimeTheme
import org.junit.Rule
import org.junit.Test

class TipCalculatorUITests {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val calculatorViewModel = CalculatorViewModel()

    @Test
    fun calculate_20_percent_tip() {
        composeTestRule.setContent {
            TipTimeTheme {
                CalculatorApp(
                    viewModel = calculatorViewModel,
                )
            }
        }
        composeTestRule.onNodeWithText("Bill Amount")
            .performTextInput("10")
        composeTestRule.onNodeWithText("Tip Percentage")
            .performTextInput("20")
        val expectedResult = NumberFormat.getCurrencyInstance().format(2)

        composeTestRule.onNodeWithText(text = "Tip Amount:", substring = true)
            .assertTextContains(value = expectedResult, substring = true)
    }
}