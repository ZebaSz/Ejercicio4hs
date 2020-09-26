package zebaszp.ejercicio4hs.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import zebaszp.ejercicio4hs.domain.Meal

class DetailViewModel : ViewModel() {
    val meal = MutableLiveData<Meal>()
}