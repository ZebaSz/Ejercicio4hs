package zebaszp.ejercicio4hs.ui.main

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import zebaszp.ejercicio4hs.domain.Meal
import zebaszp.ejercicio4hs.utils.Loading
import zebaszp.ejercicio4hs.utils.Result
import zebaszp.ejercicio4hs.utils.Success
import zebaszp.ejercicio4hs.utils.tryCatching

class MainViewModel(private val service: MealService) : ViewModel() {
    val searchTerm = MutableLiveData<String>()
    val results: LiveData<Result<List<Meal>>> = Transformations.switchMap(searchTerm) { newTerm ->
        liveData {
            if (!newTerm.isNullOrBlank()) {
                emit(Loading)
                viewModelScope.launch(Dispatchers.IO) {
                    emit(Result.tryCatching {
                        service.search(newTerm)
                    })
                }
            } else {
                emit(Success(listOf<Meal>()))
            }
        }
    }
}