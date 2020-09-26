package zebaszp.ejercicio4hs.ui.main

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import zebaszp.ejercicio4hs.domain.Meal
import zebaszp.ejercicio4hs.utils.Loading
import zebaszp.ejercicio4hs.utils.Result
import zebaszp.ejercicio4hs.utils.Success
import zebaszp.ejercicio4hs.utils.tryCatching

class MainViewModel(private val service: MealService) : ViewModel() {
    val searchTerm = MutableLiveData<String>()
    val results: LiveData<Result<List<Meal>>> = searchTerm.switchMap { newTerm ->
        liveData(context = viewModelScope.coroutineContext + Dispatchers.IO) {
            if (!newTerm.isNullOrBlank()) {
                emit(Loading)
                emit(Result.tryCatching { service.search(newTerm).meals })
            } else {
                emit(Success(listOf<Meal>()))
            }
        }
    }
}