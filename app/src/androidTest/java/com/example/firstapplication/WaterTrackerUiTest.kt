package com.example.firstapplication

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.firstapplication.ui.theme.FirstApplicationTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class WaterTrackerUiTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            FirstApplicationTheme {
                WaterTracker()
            }
        }
    }

    private fun addWater(times: Int) {
        repeat(times) {
            composeTestRule.onNodeWithText("+250 мл").performClick()
        }
    }

    private fun endDay() {
        composeTestRule.onNodeWithText("Завершить день").performClick()
    }

    @Test
    fun addButton_existsAndAdds250ml() {
        composeTestRule.onNodeWithText("+250 мл").assertIsDisplayed()
        composeTestRule.onNodeWithText("0 мл").assertIsDisplayed()

        addWater(1)
        composeTestRule.onNodeWithText("250 мл").assertIsDisplayed()

        addWater(2)
        composeTestRule.onNodeWithText("750 мл").assertIsDisplayed()
    }

    @Test
    fun endDayButton_existsAndResetsCounter() {
        composeTestRule.onNodeWithText("Завершить день").assertIsDisplayed()

        addWater(3)
        composeTestRule.onNodeWithText("750 мл").assertIsDisplayed()

        endDay()
        composeTestRule.onNodeWithText("0 мл").assertIsDisplayed()
    }

    @Test
    fun streakText_countsDaysWithGoalAndResets() {
        composeTestRule.onNodeWithText("Дней подряд: 0").assertIsDisplayed()

        addWater(6)
        endDay()
        composeTestRule.onNodeWithText("Дней подряд: 1").assertIsDisplayed()

        addWater(7)
        endDay()
        composeTestRule.onNodeWithText("Дней подряд: 2").assertIsDisplayed()

        addWater(2)
        endDay()
        composeTestRule.onNodeWithText("Дней подряд: 0").assertIsDisplayed()
    }
}