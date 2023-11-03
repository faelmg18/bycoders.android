package com.example.bycodersexchange.components

import androidx.compose.material.Surface
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.bycodersexchange.constatns.ByCodersConstants.Strings.COMPOSE_TEST_TAG_EXCHANGE_LIST
import com.example.bycodersexchange.core.extensions.setContentOnActivity
import com.example.bycodersexchange.model.Exchange
import com.example.bycodersexchange.ui.MainActivity
import com.example.bycodersexchange.ui.components.ExchangeList
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExchangeTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule(MainActivity::class.java)

    @Test
    fun testExchangeListScreenIfExchangeAreEmpty() {

        val listItems = emptyList<Exchange>()

        composeTestRule.setContentOnActivity {
            Surface {
                ExchangeList(exchanges = listItems) {
                }
            }
        }

        composeTestRule.onNodeWithTag(COMPOSE_TEST_TAG_EXCHANGE_LIST)
            .onChildren()
            .assertCountEquals(0)
    }

    @Test
    fun testExchangeListScreenIfExchangeAreNotEmpty() {

        val listItems = listOf<Exchange>(Exchange())

        composeTestRule.setContentOnActivity {
            Surface {
                ExchangeList(exchanges = listItems) {
                }
            }
        }

        composeTestRule.onNodeWithTag(COMPOSE_TEST_TAG_EXCHANGE_LIST)
            .onChildren()
            .assertCountEquals(1)
    }

    @Test
    fun testExchangeListScreenIfFirstElementIsEquals() {

        val listItems = listOf<Exchange>(Exchange(name = "Exchange Name"))

        composeTestRule.setContentOnActivity {
            Surface {
                ExchangeList(exchanges = listItems) {
                }
            }
        }

        composeTestRule.onNodeWithTag(COMPOSE_TEST_TAG_EXCHANGE_LIST)
            .onChildren()
            .onFirst()
            .assert(hasText("Exchange Name"))
    }

    @Test
    fun testExchangeListScreenIfPerformClickIsCalled() {

        val listItems = listOf<Exchange>(Exchange(name = "Exchange Name"))

        composeTestRule.setContentOnActivity {
            Surface {
                ExchangeList(exchanges = listItems) {}
            }
        }

        composeTestRule.onNodeWithTag(COMPOSE_TEST_TAG_EXCHANGE_LIST)
            .onChildren()
            .onFirst()
            .performClick()
            .assertHasClickAction()
    }
}