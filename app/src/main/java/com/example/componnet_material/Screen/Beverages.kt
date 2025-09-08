package com.example.componnet_material.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componnet_material.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true, showSystemUi = true)
fun Beverages() {
    Column(
        modifier = Modifier.padding(16.dp),
    ) {
        Scaffold (topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Beverages", fontWeight = FontWeight.Bold, fontSize = 20.sp, textAlign = TextAlign.Center) },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "Back",
                        tint = Color.Black,
                        modifier = Modifier.size(30.dp)
                    )
                },
                actions = {
                    Icon(
                        painter = painterResource(R.drawable.sitting),
                        contentDescription = "Back",
                        tint = Color.Black,
                        modifier = Modifier.size(20.dp)
                    )
                })
        }) {innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(8.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ){
                    items(beverages.size){index ->
                        BeverageCard(items = beverages[index])

                    }
                }
            }

        }

    }
}

@Composable
fun BeverageCard(items: Item){
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .width(160.dp)
        ,
        colors = CardDefaults.cardColors(Color.White),
        border = CardDefaults.outlinedCardBorder(),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = items.image),
                contentDescription = items.name,
                modifier = Modifier.fillMaxWidth().size(100.dp),
            )
            Spacer(Modifier.height(8.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
                Text(items.name, fontWeight = FontWeight.Bold, textAlign = TextAlign.Start)
            }
            Row(modifier = Modifier.fillMaxWidth().height(30.dp), horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
                Text(items.weight, fontWeight = FontWeight.Medium, color = Color.Gray, textAlign = TextAlign.Left)
            }

            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text(items.price, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(8.dp))
                Button(
                    onClick = {  },
                    colors = ButtonDefaults.buttonColors(Color(0xFF53B175)),
                    shape = RoundedCornerShape(14.dp),
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier.size(40.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                        modifier = Modifier.size(28.dp),
                        tint = Color.White
                    )
                }
            }

        }
    }
}

data class Item (val name: String,val weight: String, val price: String, val image: Int)
val beverages = listOf(
    Item("Diet Coke","355ml, Price", "$1.99", R.drawable.diet_coke),
    Item("Sprite Can","325ml, Price", "$1.50", R.drawable.sprice),
    Item("Apple & Grape Juice","2L, Price", "$15.99", R.drawable.apple_juice),
    Item("Orenge Juice","2L, Price", "$15.99", R.drawable.orenge_juice),
    Item("Coca Cola Can","325ml, Price", "$4.99", R.drawable.coca),
    Item("Pepsi Can ","325ml, Price", "$4.99", R.drawable.pepsi),
    Item("Sprite Can","325ml, Price", "$1.50", R.drawable.sprice),
    Item("Apple & Grape Juice","2L, Price", "$15.99", R.drawable.apple_juice),
    Item("Diet Coke","355ml, Price", "$1.99", R.drawable.diet_coke),
    Item("Sprite Can","325ml, Price", "$1.50", R.drawable.sprice),
    Item("Apple & Grape Juice","2L, Price", "$15.99", R.drawable.apple_juice),
    )

