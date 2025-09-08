package com.example.componnet_material.Screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.componnet_material.R
import kotlin.random.Random

@Composable
fun Explore(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "Find Product",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))
        var search by remember { mutableStateOf("") }
        TextField(
            value = search,
            onValueChange = { search = it },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            placeholder = { Text("Search Store") },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent
            ),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(items) { item ->
                CategoryCard(item,navController = navController)
            }
        }
    }
}

@Composable
fun CategoryCard(item: AllItems,navController: NavController) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .clickable {
                if (item.name == "Beverages") {
                    navController.navigate("Beverages")
                }
            },
        border = BorderStroke(1.dp, item.color),
        colors = CardDefaults.cardColors(containerColor = item.color.copy(0.2f))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = item.image),
                contentDescription = item.name,
                modifier = Modifier
                    .size(100.dp)
                    .padding(bottom = 8.dp)
            )
            Text(
                text = item.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        }
    }
}

data class AllItems(val name: String, val image: Int,val color: Color)

val items = listOf(
    AllItems("Frash Fruits\n& Vegetable", R.drawable.vegetable,Color(0xFF53B175B2)),
    AllItems("Cooking Oil\n& Ghee", R.drawable.oil,Color(0xFFF8A44CB2)),
    AllItems("Meat & Fish", R.drawable.meat,Color(0xFFF7A593)),
    AllItems("Bakery & Snacks", R.drawable.snacks,Color(0xFFD3B0E0)),
    AllItems("Dairy & Eggs", R.drawable.diary,Color(0xFFFDE598)),
    AllItems("Beverages", R.drawable.drinks,Color(0xFFB7DFF5)),
    AllItems("Meat & Fish", R.drawable.meat,Color(0xFFF7A593)),
    AllItems("Bakery & Snacks", R.drawable.snacks,Color(0xFFD3B0E0)),

    )
