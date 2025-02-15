package com.kourounis.walleeassesmentkourounis.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = "pin-pad-screen",
        modifier = modifier
    ) {
        composable("pin-pad-screen") {
//            PinPadScreen(
//                viewModel = hiltViewModel()
//            )
        }
    }
}