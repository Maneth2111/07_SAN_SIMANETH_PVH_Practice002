package com.example.componnet_material.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material3.Icon
import androidx.wear.compose.material3.Text
import com.example.componnet_material.R

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun Singup(){
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Row(modifier = Modifier.fillMaxWidth().padding(60.dp),horizontalArrangement = Arrangement.Center) {
            Image(
                painter = painterResource(id = R.drawable.carrot),
                contentDescription = "Carrot",
                modifier = Modifier.size(50.dp)
            )
        }
        Text(
            text = "Sign up",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.padding(6.dp))
        Text(
            text = "Enter your credentials to continue",
            fontWeight = FontWeight.Medium,
            color = Color.Gray,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.padding(16.dp))
        var userName by remember { mutableStateOf("") }
        Text("Username", fontWeight = FontWeight.Medium, color = Color.Gray, fontSize = 15.sp)
        TextField(
            value = userName,
            onValueChange = {userName = it},
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Gray.copy(0.4f),)
        )

        Spacer(modifier = Modifier.padding(16.dp))
        var email by remember { mutableStateOf("") }
        Text("Email", fontWeight = FontWeight.Medium, color = Color.Gray, fontSize = 15.sp)
        TextField(
            value = email,
            onValueChange = {email = it},
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Gray.copy(0.4f),)
        )

        Spacer(modifier = Modifier.padding(16.dp))
        var password by remember { mutableStateOf("") }
        Text("Password", fontWeight = FontWeight.Medium, color = Color.Gray, fontSize = 15.sp)
        TextField(
            value = password,
            onValueChange = {password = it},
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.closeeye),
                    contentDescription = "Eye",
                    tint = Color.Gray
                )
            },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Gray.copy(0.4f),)
        )
        Spacer(modifier = Modifier.padding(8.dp))

        Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Start) {
            Text(
                "By continuing you agree to our ",
                fontWeight = FontWeight.Medium,
                color = Color.Gray,
                fontSize = 14.sp,
                letterSpacing = TextUnit.Unspecified
            )
            Text(
                "Terms of Service",
                fontWeight = FontWeight.Medium,
                color = Color(0xFF53B175).copy(0.6f),
                fontSize = 14.sp,
                letterSpacing = TextUnit.Unspecified
            )
        }
        Spacer(modifier = Modifier.padding(5.dp))
        Row() {
            Text(
                "and ",
                fontWeight = FontWeight.Medium,
                color = Color.Gray,
                fontSize = 14.sp,
                letterSpacing = TextUnit.Unspecified
            )
            Text(
                "Privacy Policy.",
                fontWeight = FontWeight.Medium,
                color = Color(0xFF53B175).copy(0.7f),
                fontSize = 14.sp,
                letterSpacing = TextUnit.Unspecified
            )
        }

        Spacer(modifier = Modifier.padding(16.dp))
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF53B175),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(14.dp),
            modifier = Modifier.fillMaxWidth()) {
            Text(text = "Sign up", fontSize = 18.sp,modifier = Modifier.padding(8.dp))
        }
        Spacer(modifier = Modifier.padding(16.dp))
        Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Center) {
            Text(text = "Already have an account? ", fontWeight = FontWeight.Normal, color = Color.Black, fontSize = 15.sp)
            Text(text = "Log In",fontWeight = FontWeight.Medium, color = Color(0xFF53B175), fontSize = 15.sp)
        }
    }
}