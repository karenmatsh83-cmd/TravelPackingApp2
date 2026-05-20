package com.example.travelpackingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.jvm.java

class MainActivity : ComponentActivity() {

    companion object {

        val itemName = arrayOfNulls<String>(10)
        val category = arrayOfNulls<String>(10)
        val quantity = IntArray(10)
        val comments = arrayOfNulls<String>(10)

        var index = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            var item by remember { mutableStateOf("") }
            var categoryText by remember { mutableStateOf("") }
            var quantityText by remember { mutableStateOf("") }
            var commentsText by remember { mutableStateOf("") }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
                    .verticalScroll(rememberScrollState())
            ) {

                OutlinedTextField(
                    value = item,
                    onValueChange = { item = it },
                    label = { Text("Item Name") }
                )

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = categoryText,
                    onValueChange = { categoryText = it },
                    label = { Text("Category") }
                )

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = quantityText,
                    onValueChange = { quantityText = it },
                    label = { Text("Quantity") }
                )

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = commentsText,
                    onValueChange = { commentsText = it },
                    label = { Text("Comments") }
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = {

                        if (item.isEmpty() ||
                            categoryText.isEmpty() ||
                            quantityText.isEmpty() ||
                            commentsText.isEmpty()
                        ) {

                            Toast.makeText(
                                this@MainActivity,
                                "Please fill all fields",
                                Toast.LENGTH_SHORT
                            ).show()

                        } else {

                            itemName[index] = item
                            category[index] = categoryText
                            quantity[index] = quantityText.toInt()
                            comments[index] = commentsText

                            index++

                            Toast.makeText(
                                this@MainActivity,
                                "Item Added",
                                Toast.LENGTH_SHORT
                            ).show()

                            item = ""
                            categoryText = ""
                            quantityText = ""
                            commentsText = ""
                        }
                    }
                ) {
                    Text("Add Item")
                }

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    onClick = {

                        val intent = Intent(this@MainActivity, SecondActivity::class.java)

                        intent.putExtra("item", itemName[0])
                        intent.putExtra("category", category[0])
                        intent.putExtra("quantity", quantity[0].toString())
                        intent.putExtra("comments", comments[0])

                        startActivity(intent)
                    }
                ) {
                    Text("View Packing List")
                }
            }
        }
    }
}
