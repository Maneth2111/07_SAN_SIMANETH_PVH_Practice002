package com.example.componnet_material.Screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
@Composable
fun Filter(onApplyFilter: () -> Unit, onDismiss: () -> Unit) {
    val categories = listOf("Eggs", "Noodles & Pasta", "Chips & Crisps", "Fast Food")
    val brands = listOf("Individual Collection", "Ifad", "Kazi Farmas")
    val selectedCategories = remember { mutableStateListOf("Eggs") }
    val selectedBrands = remember { mutableStateListOf("Individual Collection") }

    Column (
//        onDismissRequest = { onDismiss() },
//        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
//        containerColor = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Filters",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(text = "Categories", fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 8.dp))
            categories.forEach { category ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .clickable {
                            if (selectedCategories.contains(category)) {
                                selectedCategories.remove(category)
                            } else {
                                selectedCategories.add(category)
                            }
                        }
                ) {
                    Checkbox(
                        checked = selectedCategories.contains(category),
                        onCheckedChange = {
                            if (it) selectedCategories.add(category) else selectedCategories.remove(category)
                        }
                    )
                    Text(text = category)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Brand", fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 8.dp))
            brands.forEach { brand ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .clickable {
                            if (selectedBrands.contains(brand)) {
                                selectedBrands.remove(brand)
                            } else {
                                selectedBrands.add(brand)
                            }
                        }
                ) {
                    Checkbox(
                        checked = selectedBrands.contains(brand),
                        onCheckedChange = {
                            if (it) selectedBrands.add(brand) else selectedBrands.remove(brand)
                        }
                    )
                    Text(text = brand)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = {
                    onApplyFilter()
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Apply Filter", color = Color.White)
            }
        }
    }
}