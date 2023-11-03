package com.example.bycodersexchange.components

import androidx.compose.material.Surface
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.bycodersexchange.constatns.ByCodersConstants.Strings.COMPOSE_TEST_TAG_EXCHANGE_COMPONENT_DETAIL
import com.example.bycodersexchange.constatns.ByCodersConstants.Strings.COMPOSE_TEST_TAG_EXCHANGE_COMPONENT_ITEM
import com.example.bycodersexchange.core.extensions.setContentOnActivity
import com.example.bycodersexchange.model.Exchange
import com.example.bycodersexchange.ui.MainActivity
import com.example.bycodersexchange.ui.components.ExchangeComponentDetail
import com.example.bycodersexchange.ui.components.ExchangeComponentItem
import com.example.bycodersexchange.ui.components.ExchangeList
import com.example.bycodersexchange.ui.screens.exchangedetail.ExchangeDetailScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExchangeComponentDetailItemTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule(MainActivity::class.java)

    @Test
    fun testExchangeListScreenIfFirstElementIsEquals() {

        val exchange = Exchange(exchangeId = "Exchange Id", name = "Exchange Name")

        composeTestRule.setContentOnActivity {
            Surface {
                ExchangeComponentItem(exchange = exchange)
            }
        }

        composeTestRule.onNodeWithTag(COMPOSE_TEST_TAG_EXCHANGE_COMPONENT_ITEM)
            .assert(hasText("Exchange Id"))
            .assert(hasText("Exchange Name"))
    }
}