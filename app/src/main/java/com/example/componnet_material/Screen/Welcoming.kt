package com.example.componnet_material.Screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.componnet_material.R

@Composable
fun Welcome(navController: NavController){
    Column(modifier = Modifier.fillMaxSize()){
        Box(){
            Image(
                painter = painterResource(id = R.drawable.man),
                contentDescription = "man",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                contentAlignment = Alignment.BottomCenter,
                modifier = Modifier.fillMaxSize().padding(30.dp)

            ){
                Column(
                    modifier = Modifier.fillMaxWidth(),horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.white_carrot),
                        contentDescription = "Carrot",
                        modifier = Modifier.size(60.dp)
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(text = "Welcome", fontWeight = FontWeight.Bold, fontSize = 50.sp, color = Color.White)
                    Text(text = "to our store", fontWeight = FontWeight.Bold, fontSize = 50.sp, color = Color.White)
                    Text(text = "Ger your groceries in as fast as one hour", fontWeight = FontWeight.Medium, fontSize =16.sp, color = Color.Gray)
                    Spacer(modifier = Modifier.height(40.dp))
                    Button(
                        onClick = { navController.navigate("Login") },
                        modifier = Modifier.fillMaxWidth().height(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF53B175),
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(text = "Get Started")
                    }
                    Spacer(modifier = Modifier.height(50.dp))

                }
            }
        }

    }
}