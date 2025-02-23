package com.lobito.utilscalera.data.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.lobito.appbusesvip.presentation.login.LoginScreen
import com.lobito.appbusesvip.presentation.splash.SplashScreen

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Splash) {
        composable<Splash> {
            SplashScreen { navController.navigate(Login){
                popUpTo(Login) { inclusive = true }} }
        }

        composable<Login> {
            LoginScreen()
//            {
////                navController.navigate(Home)
//            }

        }

//        composable<Identification> {
//            IdentificationScreen {
//                navController.navigate(Splash){
//                popUpTo(Splash) { inclusive = true }}
//            }
//        }
//
//        composable<Home> {
//            HomeScreen { name -> navController.navigate(Detail(name = name)) }
//        }
//
//        composable<Detail> { backStackEntry ->
//            val detail: Detail = backStackEntry.toRoute()
//            DetailScreen(name = detail.name,
//                navigateBack = { navController.navigateUp() },
//                navigateToSettings = {navController.navigate(Settings(it))})
//        }
//
//        composable<Settings>(typeMap = mapOf(typeOf<SettingsInfo>() to createNavType<SettingsInfo>())){
//            backStackEntry ->
//            val settings: Settings = backStackEntry.toRoute()
//            SettingsScreen(settings.info)
//        }
    }
}