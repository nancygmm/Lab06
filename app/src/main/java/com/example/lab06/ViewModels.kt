package com.example.lab06
import androidx.compose.ui.graphics.painter.Painter
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab06.source.City
import com.example.lab06.source.TeleportApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ViewModels {

}

class CityListViewModel : ViewModel() {
    private val _cities = MutableStateFlow<List<City>>(emptyList())
    val cities: StateFlow<List<City>> = _cities

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.teleport.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val teleportApi = retrofit.create(TeleportApi::class.java)


    init {
        viewModelScope.launch {
            val citiesResponse = retrofit.create(TeleportApi::class.java).getCities()
            _cities.value = citiesResponse
        }
    }
}

class CityDetailViewModel : ViewModel() {
    private val _cityImage = MutableStateFlow<Painter?>(null)
    val cityImage: StateFlow<Painter?> = _cityImage

    fun getCityImage(slug: String) {
        viewModelScope.launch {
            try {
                val imageUrl = "https://api.teleport.org/api/urban_areas/slug:$slug/images/"
                //val response = aquí se ingresa el http de la imagen que se va a solicitar
            } catch (e: Exception) {
            }
        }
    }
}

