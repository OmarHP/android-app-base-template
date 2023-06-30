package com.ohp.app.application.ui

import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ohp.app.presentation.main.MainScreen
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import com.ohp.app.application.ui.theme.MyAppTheme

@OptIn(ExperimentalMaterialNavigationApi::class)
@Composable
fun MyApp() {

    val bottomSheetNavigator = rememberBottomSheetNavigator()
    val navController = rememberNavController(bottomSheetNavigator)
    MyAppTheme {
        ModalBottomSheetLayout(
            bottomSheetNavigator = bottomSheetNavigator,
            modifier = Modifier.systemBarsPadding()
        ) {
            NavHost(navController, "main") {
                composable(route = "main") { MainScreen() }
            }
        }
    }
}