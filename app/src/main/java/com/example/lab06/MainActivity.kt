package com.example.lab06
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.lab06.ui.theme.Lab06Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab06Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun ScrollableTextScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Listado de ciudades",
            modifier = Modifier.padding(bottom = 16.dp)
        )
        var text by remember { mutableStateOf("Texto que se puede desplazar hacia arriba y abajo. ".repeat(10)) }

        BasicTextField(
            value = text,
            onValueChange = { newText ->
                text = newText
            },
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
                .weight(1f)
        )
    }
}
@Preview(showBackground = true)
@Composable
fun ScrollableTextScreenPreview() {
    MaterialTheme {
        ScrollableTextScreen()
    }
}

