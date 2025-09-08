package com.example.componnet_material.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import com.example.componnet_material.R
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
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true, showSystemUi = true)
fun Search(){
    var showFilterSheet by remember { mutableStateOf(false) }
    if (showFilterSheet) {
        Filter(
            onApplyFilter = {
                showFilterSheet = false
            },
            onDismiss = {
                showFilterSheet = false
            }
        )
    }

    Column(
        modifier = Modifier.padding(16.dp),
    ) {
        Scaffold (topBar = {
            TopAppBar(
                title = {
                    Column() {
                        var search by remember { mutableStateOf("") }
                        TextField(
                            value = search,
                            onValueChange = {search = it},
                            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                            placeholder = { Text("Search ") },
                            colors = TextFieldDefaults.colors(
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                disabledIndicatorColor = Color.Transparent,
                                errorIndicatorColor = Color.Transparent
                            ),
                            modifier = Modifier.padding(end = 16.dp),
                            shape = RoundedCornerShape(15.dp),
                        )
                    } },
                actions = {
                    IconButton(
                        onClick = { showFilterSheet = true  },
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.sitting),
                            contentDescription = "Back",
                            tint = Color.Black,
                            modifier = Modifier.size(20.dp)
                        )
                    }

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
                    items(eggs.size){index ->
                        ProductCard(eggs = eggs[index])
                    }
                }
            }

        }

    }

}

@Composable
fun ProductCard(eggs: Eggs){
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .width(160.dp).height(240.dp)
        ,
        colors = CardDefaults.cardColors(Color.White),
        border = CardDefaults.outlinedCardBorder(),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = eggs.image),
                contentDescription = eggs.name,
                modifier = Modifier.fillMaxWidth().size(100.dp),
            )
            Spacer(Modifier.height(8.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
                Text(eggs.name, fontWeight = FontWeight.Bold, textAlign = TextAlign.Start)
            }
            Row(modifier = Modifier.fillMaxWidth().height(30.dp), horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
                Text(eggs.weight, fontWeight = FontWeight.Medium, color = Color.Gray, textAlign = TextAlign.Left)
            }

            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text(eggs.price, fontWeight = FontWeight.Bold)
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



data class Eggs (val name: String,val weight: String, val price: String, val image: Int)
val eggs = listOf(
    Eggs("Egg Chicken Red","4pcs, Price", "$1.99", R.drawable.red_egg),
    Eggs("Egg Pasta ","180g, Price", "$1.50", R.drawable.egg),
    Eggs("Egg Chicken Red","30gm, Price", "$15.99", R.drawable.egg_pasta),
    Eggs("Egg Noodles","30gm, Price", "$15.99", R.drawable.egg_noodle),
    Eggs("Mayonnais Eggless","30gm, Price", "$15.99", R.drawable.mayonnaise_rggless),
    Eggs("Egg Noodles","30gm, Price", "$15.99", R.drawable.egg_nodle),

)