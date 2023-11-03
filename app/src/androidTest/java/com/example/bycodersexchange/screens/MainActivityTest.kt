package com.example.bycodersexchange.screens

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.example.bycodersexchange.constatns.ByCodersConstants.Strings.COMPOSE_TEST_TAG_EXCHANGE_LIST
import com.example.bycodersexchange.core.extensions.setContentOnActivity
import com.example.bycodersexchange.model.Exchange
import com.example.bycodersexchange.model.ScreensNavigation
import com.example.bycodersexchange.ui.MainActivity
import com.example.bycodersexchange.ui.screens.bycoderscreen.MainByCodersScreen
import com.example.bycodersexchange.utils.assertCurrentRouteName
import com.example.bycodersexchange.utils.waitUntilTimeout
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Ainda estou aprendendo sobre compose e sobre os testes de compose,
 * então pode ser que os teste de ui não esteja tão completo
 */

class MainActivityTest {

    private var exchange: Exchange? = null
    private lateinit var navController: TestNavHostController

    @get:Rule
    val composeTestRule = createAndroidComposeRule(MainActivity::class.java)

    @Before
    fun setupMoodTrackerAppNavHost() {
        composeTestRule.setContentOnActivity {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            MainByCodersScreen(navController = navController)
        }
    }

    @Test
    fun testIfFirstScreenIsExchangeScreen() {
        composeTestRule.waitUntilTimeout(10000)
        navController.assertCurrentRouteName(ScreensNavigation.ExchangesScreen.router)
    }

    @Test
    fun testIfOnCLickItemIsScreenChangeToExchangesDetailScreen() {

        val listItems = emptyList<Exchange>()

        composeTestRule.setContentOnActivity {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            MainByCodersScreen(navController = navController)
        }

        composeTestRule.waitUntilTimeout(10000)
        composeTestRule.onNodeWithTag(COMPOSE_TEST_TAG_EXCHANGE_LIST)
            .onChildren()
            .onFirst()
            .performClick()
        navController.assertCurrentRouteName(ScreensNavigation.ExchangesDetailScreen.router)
    }
}
