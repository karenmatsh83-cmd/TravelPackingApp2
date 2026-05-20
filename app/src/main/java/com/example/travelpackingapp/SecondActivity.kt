package com.example.travelpackingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val item = intent.getStringExtra("item") ?: ""
        val category = intent.getStringExtra("category") ?: ""
        val quantity = intent.getStringExtra("quantity") ?: ""
        val comments = intent.getStringExtra("comments") ?: ""

        setContent {
            PackingScreen(item, category, quantity, comments)
        }
    }
}

@Composable
fun PackingScreen(
    item: String,
    category: String,
    quantity: String,
    comments: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Item: $item")
        Text("Category: $category")
        Text("Quantity: $quantity")
        Text("Comments: $comments")

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { }) {
            Text("Return to Main Screen")
        }
    }
}