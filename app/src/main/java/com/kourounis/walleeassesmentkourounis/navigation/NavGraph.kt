package com.kourounis.walleeassesmentkourounis.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.kourounis.walleeassesmentkourounis.views.PinPadScreen


@Composable
inline fun <reified T : ViewModel> NavHostController.navigationViewModel(
    current: NavBackStackEntry,
    route: String
): T {
    return hiltViewModel(remember(current) { this.getBackStackEntry(route) })
}

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = "main",
        modifier = modifier
    ) {
        mainGraph(navController)
    }
}

private fun NavGraphBuilder.mainGraph(
    navController: NavHostController,
) {
    navigation(
        route = "main",
        startDestination = "main/pin-pad-screen"
    ) {
        composable("main/pin-pad-screen") {
            PinPadScreen(
                viewModel = navController.navigationViewModel(
                    current = it,
                    route = "main"
                ),
                onReceipt = {}
            )
        }
    }
}