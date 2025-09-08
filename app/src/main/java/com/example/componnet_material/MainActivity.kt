package com.example.componnet_material

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.ui.Alignment
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
import com.example.componnet_material.Screen.ProductDetail
import com.example.componnet_material.Screen.Search
import com.example.componnet_material.Screen.Shop

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
            Search()
            CartScreen()

        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreen() {

    val navigation = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navigation) }
    ) {innerPadding ->
        NavHost (
            navController = navigation,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ){
            composable("home") { Shop() }
            composable("Explore") { Explore() }
            composable("Account"){ Account() }
        }

    }
}

@Composable
fun ScreenContent(text: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text, style = MaterialTheme.typography.headlineMedium)
    }
}
@Composable
fun BottomBar(navController: NavController) {
    val items = listOf(
//        navController.navigate("home"),
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
