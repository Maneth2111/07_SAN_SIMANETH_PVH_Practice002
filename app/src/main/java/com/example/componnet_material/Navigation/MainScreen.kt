package com.example.componnet_material.Navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.componnet_material.Screen.Account
import com.example.componnet_material.Screen.CartScreen
import com.example.componnet_material.Screen.Explore
import com.example.componnet_material.Screen.Favorite
import com.example.componnet_material.Screen.Filter
import com.example.componnet_material.Screen.Shop

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreen() {

    val navigation = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navigation) }
    ) {innerPadding ->
        NavHost (
            navController = navigation,
            startDestination = "Shop",
            modifier = Modifier.padding(innerPadding)
        ){
            composable("Shop") { Shop() }
            composable("Explore") { Explore(navigation) }
            composable("Account"){ Account() }
            composable("Favourite"){ Favorite() }
            composable("Cart"){ CartScreen(navigation) }
        }

    }
}


@Composable
fun BottomBar(navController: NavController) {
    val items = listOf(
        BottomNavItem("Shop", Icons.Default.Home, "Shop"),
        BottomNavItem("Explore", Icons.Default.Search, "Explore"),
        BottomNavItem("Cart", Icons.Default.ShoppingCart, "Cart"),
        BottomNavItem("Favourite", Icons.Default.FavoriteBorder, "Favourite"),
        BottomNavItem("Account", Icons.Default.Person, "Account")
    )

    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            NavigationBarItem(
                icon = {Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}
data class BottomNavItem(val label: String, val icon: ImageVector, val route: String)
