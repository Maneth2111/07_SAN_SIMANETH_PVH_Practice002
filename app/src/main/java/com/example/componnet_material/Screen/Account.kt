package com.example.componnet_material.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
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

data class MenuItem(val title: String, val icon: Int)

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun Account() {
    val menuItems = listOf(
        MenuItem("Orders", R.drawable.order),           // Replace with actual drawable resources
        MenuItem("My Details", R.drawable.detail),
        MenuItem("Delivery Address", R.drawable.location),
        MenuItem("Payment Methods", R.drawable.payment),
        MenuItem("Promo Code", R.drawable.promo),
        MenuItem("Notifications", R.drawable.bell),
        MenuItem("Help", R.drawable.help),
        MenuItem("About", R.drawable.about)
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            // Profile Picture and Name
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pro),
                    contentDescription = "Profile Picture",
                    modifier = Modifier.size(64.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Row {
                        Text(
                            text = "Penh Seyha",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        IconButton(
                            onClick = { /* Handle edit click */ },
                            modifier = Modifier.size(24.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.edit),
                                contentDescription = "Edit",
                                tint = Color(0xFF53B175),
                                modifier = Modifier.size(18.dp)
                            )
                        }

                    }

                    Text(
                        text = "penhseyha4980@gmail.com",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }
            }

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 5.dp),
                thickness = 1.dp,
                color = Color.LightGray
            )
            menuItems.forEach { item ->
                ProfileMenuItem(item)
                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 5.dp),
                    thickness = 1.dp,
                    color = Color.LightGray
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {  },
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth().height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF2F3F2),
                    contentColor = Color(0xFF53B175)
                )
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.logout),
                        contentDescription = "Log Out",
                        tint = Color(0xFF53B175),
                    )
                    Text(
                        text = "Log Out",
                        color = Color(0xFF53B175),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
        }

}

@Composable
fun ProfileMenuItem(menuItem: MenuItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = menuItem.icon),
                contentDescription = menuItem.title,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = menuItem.title,
                fontSize = 16.sp
            )
        }
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = "arrow right",
            tint = Color.Black,
            modifier = Modifier.size(26.dp)
        )
    }
}