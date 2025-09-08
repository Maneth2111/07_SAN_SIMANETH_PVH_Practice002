package com.example.componnet_material.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componnet_material.R
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true, showSystemUi = true)
fun CartScreen() {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }

    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false },
            sheetState = sheetState,
            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
            containerColor = Color.LightGray
        ) {

            Checkout(onClose = {
                scope.launch { sheetState.hide() }.invokeOnCompletion {
                    if (!sheetState.isVisible) {
                        showBottomSheet = false
                    }
                }
            })
        }
    }

    Scaffold(
        bottomBar = {
            Button(
                onClick = {
                    showBottomSheet = true
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(56.dp)
            ) {
                Text(
                    text = "Go to Checkout",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Text(
                text = "My Cart",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
            )

            // Cart items list
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            ) {
                itemsIndexed(cartItems) { index, item ->
                    CartItemRow(item)

                    if (index < cartItems.lastIndex) {
                        HorizontalDivider(
                            modifier = Modifier.padding(vertical = 8.dp),
                            thickness = 1.dp,
                            color = Color.Gray.copy(alpha = 0.3f)
                        )
                    }
                }
            }
        }
    }
}
@Composable
fun CartItemRow(item: CartItem) {
    var quantity by remember { mutableStateOf(1) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Left: Image + Details
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = item.image),
                contentDescription = item.name,
                modifier = Modifier
                    .size(80.dp)
                    .padding(end = 12.dp)
            )
            Column {
                Row(verticalAlignment = Alignment.CenterVertically,horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()){
                    Text(text = item.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    IconButton(onClick = { /* TODO: Remove item */ }) {
                        Icon(Icons.Default.Close, contentDescription = "Remove", tint = Color.Gray)
                    }


                }
                Text(text = item.detail, color = Color.Gray, fontSize = 13.sp)
                Spacer(modifier = Modifier.height(8.dp))

                Row(verticalAlignment = Alignment.CenterVertically,horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Button(
                            onClick = { if (quantity > 1) quantity-- },
                            shape = RoundedCornerShape(18.dp),
                            border = ButtonDefaults.outlinedButtonBorder,
                            colors = ButtonDefaults.buttonColors(
                                Color.White)

                        ) {
                            Icon(painter = painterResource(R.drawable.minus), contentDescription = "minus", tint = Color.Gray, modifier = Modifier.size(26.dp))
                        }

                        Text(text = "$quantity", fontWeight = FontWeight.Bold, fontSize = 14.sp)

                        IconButton(
                            onClick = { quantity++ },

                            ) {
                            Icon(imageVector = Icons.Default.Add, contentDescription = "Add", tint = Color.Gray, modifier = Modifier.size(26.dp))
                        }
                    }
                    Text(
                        text = "${item.price}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(end = 18.dp)
                    )

                }

            }
        }


        Column(horizontalAlignment = Alignment.Start, modifier = Modifier.fillMaxHeight()) {


        }
    }
}

data class CartItem(val name: String, val detail: String, val price: String, val image: Int)

val cartItems = listOf(
    CartItem("Bell Pepper Red", "1kg, Price", "$4.99", R.drawable.pepper),
    CartItem("Egg Chicken Red", "4pcs, Price", "$1.99", R.drawable.egg),
    CartItem("Organic Bananas", "12kg, Price", "$3.00", R.drawable.banana),
    CartItem("Ginger", "250gm, Price", "$2.99", R.drawable.ginger)
)
