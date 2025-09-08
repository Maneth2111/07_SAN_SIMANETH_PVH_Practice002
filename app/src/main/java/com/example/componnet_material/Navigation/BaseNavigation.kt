package com.example.componnet_material.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.componnet_material.Screen.Beverages
import com.example.componnet_material.Screen.Loging
import com.example.componnet_material.Screen.OrderAccept
import com.example.componnet_material.Screen.ProductDetail
import com.example.componnet_material.Screen.Singup
import com.example.componnet_material.Screen.Welcome

@Composable
fun BaseNavigation() {
    val navigation = rememberNavController()

    NavHost(
        navController = navigation,
        startDestination = "Welcome"
    ) {
        composable("Welcome") { Welcome(navigation) }
        composable("Login") { Loging(navigation) }
        composable("SignUp") { Singup(navigation) }
        composable("ProductDetails") { ProductDetail() }
        composable("Beverages") { Beverages() }
        composable("Accept") { OrderAccept() }
        composable("Main") { MainScreen() }
    }
}