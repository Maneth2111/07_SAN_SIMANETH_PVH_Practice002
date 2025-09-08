package com.example.componnet_material.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componnet_material.R


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun Favorite(){
    Scaffold(
        bottomBar = {
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp).padding(bottom = 30.dp)
                    .height(56.dp)
            ) {
                Text(text = "Add All To Cart", fontSize = 18.sp, color = Color.White)
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Text(
                text = "Favourite",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            ) {
                items(favoriteItems.size) { index ->
                    FavouriteItemRow(favoriteItems[index])
                    HorizontalDivider(
                        modifier = Modifier.padding(vertical = 12.dp),
                        thickness = 1.dp,
                        color = Color.Gray.copy(0.4f)
                    )
                }
            }


        }
    }

}
@Composable
fun FavouriteItemRow(item: FavoriteItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = item.image),
                contentDescription = item.name,
                modifier = Modifier
                    .size(50.dp)
                    .padding(end = 12.dp)
            )
            Column {
                Text(text = item.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(text = item.weight, color = Color.Gray, fontSize = 13.sp)
            }
        }
        Text(text = item.price, fontWeight = FontWeight.Bold, fontSize = 15.sp)
    }
}




data class FavoriteItem(val name: String,val weight: String, val price: String, val image: Int)
val favoriteItems = listOf(
    FavoriteItem("Sprite Can","325ml, Price", "$1.50", R.drawable.sprice),
    FavoriteItem("Diet Coke","355ml, Price", "$1.99", R.drawable.diet_coke),
    FavoriteItem("Apple & Grape Juice","2L, Price", "$15.99", R.drawable.apple_juice),
    FavoriteItem("Orenge Juice","2L, Price", "$15.99", R.drawable.orenge_juice),
    FavoriteItem("Coca Cola Can","325ml, Price", "$4.99", R.drawable.coca),
    )