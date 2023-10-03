package com.example.lab06

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab06.ui.theme.Lab06Theme
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.example.lab06.source.City


class CityList : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab06Theme {
                // A surface container using the 'background' color from the theme
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
fun CityListScreen(viewModel: CityListViewModel) {
    val cities by viewModel.cities.collectAsState()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(cities) { city ->
            CityListItem(city = city)
        }
    }
}

@Composable
fun CityListItem(city: City) {
    var image by remember { mutableStateOf<Painter?>(null) }
    val viewModel: CityDetailViewModel = viewModel()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                viewModel.getCityImage(city.slug)
            }
    ) {
        image?.let { painter ->
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .padding(8.dp)
                    .clip(MaterialTheme.shapes.medium)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = city.name,
            modifier = Modifier
                .align(Alignment.CenterVertically)
        )
    }
}

fun viewModel(): CityDetailViewModel {

    return TODO("Provide the return value")
}

@Composable
fun CityDetailScreen(viewModel: CityDetailViewModel) {
    val cityImage by viewModel.cityImage.collectAsState()

    // Muestra la imagen de la ciudad
    cityImage?.let { image ->
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab06Theme {

    }
}