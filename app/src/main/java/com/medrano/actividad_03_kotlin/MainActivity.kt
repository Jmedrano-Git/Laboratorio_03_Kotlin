package com.medrano.actividad_03_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.medrano.actividad_03_kotlin.ui.theme.Actividad_03_KotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Actividad_03_KotlinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LazyColumn() {
    LazyColumn(modifier = Modifier.fillMaxWidth()){
        items(5){ index ->
                Text("Item $index", modifier = Modifier.padding(8.dp))
        }
    }
}
//LazyRow
@Composable
fun LazyRow() {
    LazyRow(modifier = Modifier.fillMaxWidth()){
        items(4){ index ->
            Text("Elemento $index", modifier = Modifier.padding(8.dp))
        }
    }
    
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Actividad_03_KotlinTheme {
        Greeting("Android")
    }
}