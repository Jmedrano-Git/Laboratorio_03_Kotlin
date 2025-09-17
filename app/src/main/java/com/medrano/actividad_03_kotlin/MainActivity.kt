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

//Grid
@Composable
fun Grid() {
    LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.height(200.dp)) {
        items(6) { index ->
            Card(modifier = Modifier.padding(8.dp)) {
                Text("Item $index", modifier = Modifier.padding(16.dp))
            }
        }
    }
}


//Scafold
@Composable
fun Scaffold() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Mi App") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(Icons.Default.Add, contentDescription = null)
            }
        }
    ) { padding ->
        Text("Contenido principal", modifier = Modifier.padding(padding))
    }
}

//Surface
@Composable
fun Surface() {
    Surface(color = Color.LightGray, modifier = Modifier.padding(8.dp)) {
        Text("Contenido dentro de Surface", modifier = Modifier.padding(16.dp))
    }
}

//Chip
@Composable
fun Chip() {
    AssistChip(
        onClick = {},
        label = { Text("Chip de acción") },
        leadingIcon = { Icon(Icons.Default.Face, contentDescription = null) }
    )
}


//CONTROLES

//AlertDialog
@Composable
fun AlertDialog() {
    var mostrar by remember { mutableStateOf(false) }
    Button(onClick = { mostrar = true }) { Text("Mostrar Alerta") }
    if (mostrar) {
        AlertDialog(
            onDismissRequest = { mostrar = false },
            title = { Text("Alerta") },
            text = { Text("Este es un mensaje de alerta.") },
            confirmButton = {
                TextButton(onClick = { mostrar = false }) { Text("Aceptar") }
            }
        )
    }
}

//Card
@Composable
fun Card() {
    Card(modifier = Modifier.padding(8.dp), elevation = CardDefaults.cardElevation(4.dp)) {
        Text("Contenido de la tarjeta", modifier = Modifier.padding(16.dp))
    }
}


//CheckBox
@Composable
fun Checkbox() {
    var checked by remember { mutableStateOf(false) }
    Row {
        Checkbox(checked = checked, onCheckedChange = { checked = it })
        Text(if (checked) "Activado" else "Desactivado")
    }
}

//FloatingActionButton
@Composable
fun FloatingActionButton() {
    FloatingActionButton(onClick = {}) {
        Icon(Icons.Default.Add, contentDescription = null)
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Actividad_03_KotlinTheme {
        Greeting("Android")
    }
}