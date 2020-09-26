package zebaszp.ejercicio4hs.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import zebaszp.ejercicio4hs.domain.MealService

const val contentType = "application/json"

class MainViewModelFactory : ViewModelProvider.Factory {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://www.themealdb.com/")
        .addConverterFactory(Json { ignoreUnknownKeys = true }.asConverterFactory(MediaType.get(contentType)))
        .build()

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        MainViewModel(retrofit.create(MealService::class.java)) as T
}
