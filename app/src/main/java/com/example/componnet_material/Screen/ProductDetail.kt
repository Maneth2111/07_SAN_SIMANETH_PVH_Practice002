package com.example.componnet_material.Screen

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import androidx.compose.ui.unit.sp
import com.example.componnet_material.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true, showSystemUi = true)
fun ProductDetail(){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(R.drawable.upload),
                            contentDescription = "Download"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFF2F3F2)
                )

            )
        }
    ) {
        innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Box(
                Modifier.background(
                    color = Color(0xFFF2F3F2), shape = RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp)
                )
            ){
                Image(
                    painter = painterResource(id = R.drawable.apple),
                    contentDescription = "Product Image",
                    modifier = Modifier.padding(16.dp)
                )
            }
            Column(modifier = Modifier.padding(16.dp)) {
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically){
                    Text(text = "Naturel Red Apple", fontWeight = FontWeight.Bold, color = Color.Black, fontSize = 25.sp)
                    IconButton(onClick = { /* Handle favorite action */ }) {
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = "Download",
                            tint = Color.Gray,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
                Text(text = "1kg, Price", color = Color.Gray, fontSize = 15.sp)
                Spacer(modifier = Modifier.padding(10.dp))

                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically){
                    BuyProduct()
                    Text("$4.99", fontWeight = FontWeight.Bold, color = Color.Black, fontSize = 20.sp)
                }

                //LINE
                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 12.dp),
                    thickness = 1.dp,
                    color = Color.Gray.copy(0.4f)
                )

                //SHOW DETAILS
                ExpandableProductDetail()

                //LINE
                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 12.dp),
                    thickness = 1.dp,
                    color = Color.Gray.copy(0.4f)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Nutritions")
                    Button(
                        onClick = {},
                        modifier = Modifier.width(90.dp),
                        shape = RoundedCornerShape(18.dp),
                        colors = ButtonDefaults.buttonColors(
                            Color.Gray.copy(0.2f)),
                    ) {
                        Text("100gr",color = Color.Gray)
                    }

                }


                //LINE
                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 16.dp),
                    thickness = 1.dp,
                    color = Color.Gray.copy(0.4f)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Review")
                    Row {
                        for (i in 1..5) {
                            Image(
                                painter = painterResource(R.drawable.star),
                                contentDescription = "Star",
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.padding(10.dp))

                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF53B175),
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(14.dp),
                    modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Add to Basket",
                        fontSize = 18.sp,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }


        }
    }
}

@Composable

fun BuyProduct(){
    var counter by remember { mutableStateOf(1) }

    Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
        IconButton(onClick = { if (counter> 1) counter--}) {
            Icon(painter = painterResource(R.drawable.minus), contentDescription = "Add", tint = Color.Gray, modifier = Modifier.size(26.dp))
        }

        Button(
            onClick = { /* Handle favorite action */ },
            shape = RoundedCornerShape(15.dp),
            border = ButtonDefaults.outlinedButtonBorder,
            colors = ButtonDefaults.buttonColors(
                Color.White),
            modifier = Modifier.height(40.dp).width(50.dp)

        ) {
            Text(text = counter.toString(), fontWeight = FontWeight.Bold, color = Color.Black, fontSize = 18.sp, textAlign = TextAlign.Center)
        }

        IconButton(onClick = { counter++}) {
            Icon(Icons.Default.Add, contentDescription = "Add", tint = Color(0xFF53B175), modifier = Modifier.size(26.dp))
        }

    }
}



@Composable
fun ExpandableProductDetail() {
    var expanded by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Product Detail",
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                color = Color.Black
            )

            IconButton(onClick = { expanded = !expanded }) {
                Icon(
                    imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = if (expanded) "Collapse" else "Expand",
                    tint = Color.Black,
                    modifier = Modifier.size(40.dp)
                )
            }
        }
        // Expandable Text
        if (expanded) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Apples are Nutritious. Apples may be good for weight loss. Apples may be good for your heart. As part of a healtful and varied diet.",
                fontSize = 14.sp,
                color = Color.Gray,
                lineHeight = 20.sp
            )
        }
    }
}
