package zebaszp.ejercicio4hs.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import retrofit2.Retrofit

class MainViewModelFactory : ViewModelProvider.Factory {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://www.themealdb.com/")
        .build()

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        MainViewModel(retrofit.create(MealService::class.java)) as T
}
