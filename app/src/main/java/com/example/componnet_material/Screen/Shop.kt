package com.example.componnet_material.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.componnet_material.R

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun Shop(){
    LazyColumn {
        item {
            ShopContent()
        }
    }
}

data class Product (val name: String,val weight: String, val price: String, val image: Int)
val exclusiveProducts = listOf(
    Product("Organic Bananas","7pcs, Price", "$4.99", R.drawable.banana),
    Product("Red Apple","1kg, Price", "$4.99", R.drawable.apple),
    Product("Organic Bananas","7pcs, Price", "$4.99", R.drawable.banana),
    Product("Red Apple","1kg, Price", "$4.99", R.drawable.apple),
)
val bestSellingProducts = listOf(
    Product("Bell Pepper Red","7pcs, Price", "$4.99", R.drawable.pepper),
    Product("Ginger","1kg, Price", "$4.99", R.drawable.ginger),
    Product("Bell Pepper Red","7pcs, Price", "$4.99", R.drawable.pepper),
    Product("Ginger","1kg, Price", "$4.99", R.drawable.ginger),
)
val groceriesProducts = listOf(
    Product("Beef Bone","1kg, Price", "$4.99", R.drawable.beef),
    Product("Broiler Chicken","1kg, Price", "$4.99", R.drawable.chicken),
    Product("Beef Bone","1kg, Price", "$4.99", R.drawable.beef),
    Product("Broiler Chicken","1kg, Price", "$4.99", R.drawable.chicken),
)


@Composable
fun ProductCard(product: Product, navController: NavController) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .width(160.dp)
            .clickable {
                navController.navigate("ProductDetails")
            },

        colors = CardDefaults.cardColors(Color.White),
        border = CardDefaults.outlinedCardBorder(),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = product.image),
                contentDescription = product.name,
                modifier = Modifier.fillMaxWidth().size(100.dp),
            )
            Spacer(Modifier.height(8.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
                Text(product.name, fontWeight = FontWeight.Bold, textAlign = TextAlign.Start)
            }
            Row(modifier = Modifier.fillMaxWidth().height(30.dp), horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
                Text(product.weight, fontWeight = FontWeight.Medium, color = Color.Gray, textAlign = TextAlign.Left)
            }

            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text(product.price, fontWeight = FontWeight.Bold)
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

@Composable
fun ProductList(products: List<Product>) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 1.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(products.size) { index ->
            ProductCard(product = products[index], navController = NavController(context = LocalContext.current))
        }


    }
}

@Composable
fun ShopContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.carrot),
            contentDescription = "Carrot",
            modifier = Modifier
                .height(30.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.width(8.dp))
        Row {
            Icon(
                imageVector = Icons.Filled.LocationOn,
                contentDescription = "Information",
                modifier = Modifier.size(24.dp),
                tint = Color(0xFF393636)
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text = "Dhaka, Banassre",
                color = Color(0xFF393636),
                style = MaterialTheme.typography.bodyLarge
            )
        }


        Spacer(modifier = Modifier.height(16.dp))
        Column {
            var search by remember { mutableStateOf("") }
            TextField(
                value = search,
                onValueChange = {search = it},
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

                )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Banner",
            modifier = Modifier
                .fillMaxWidth() ,
            contentScale = ContentScale.Crop

        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Exclusive Offer",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold)
            Text(text = "See All", color = Color.Green)
        }
        Spacer(modifier = Modifier.height(20.dp))
        // Exclusives Products
        ProductList(products = exclusiveProducts)

        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Best Selling",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold)
            Text(text = "See All", color = Color.Green)
        }
        Spacer(modifier = Modifier.height(20.dp))
        // Best selling products
        ProductList(products = bestSellingProducts)

        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Groceries",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold)
            Text(text = "See All", color = Color.Green)
        }
        Spacer(modifier = Modifier.height(20.dp))
        // Groceries Product
        CategoryItem()
        Spacer(modifier = Modifier.height(20.dp))
        ProductList(products = groceriesProducts)
    }

}

@Composable

fun CategoryItem() {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 1.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        item {
            Card(
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.width(230.dp),
                colors = CardDefaults.cardColors(Color(0xFFF8A44C).copy(0.2f)),

                ) {
                Row(
                    modifier = Modifier.padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.pulses),
                        contentDescription = "Carrot",
                        modifier = Modifier
                            .size(70.dp)
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = "Pulses",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
        item {

            Card(
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .width(230.dp),
                colors = CardDefaults.cardColors(Color(0xFF53B175).copy(0.2f)),

                ) {
                Row(
                    modifier = Modifier.padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.rice),
                        contentDescription = "rice",
                        modifier = Modifier
                            .size(70.dp)
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = "Pulses",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }


    }

}