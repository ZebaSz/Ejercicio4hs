package zebaszp.ejercicio4hs.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import zebaszp.ejercicio4hs.databinding.DetailFragmentBinding
import zebaszp.ejercicio4hs.domain.MealService


const val contentType = "application/json"

class DetailFragment : Fragment() {

    // TODO: use dep injection
    private val service = Retrofit.Builder()
        // TODO: move this to config file
        .baseUrl("https://www.themealdb.com/")
        .addConverterFactory(Json { ignoreUnknownKeys = true }.asConverterFactory(MediaType.get(contentType)))
        .build()
        .create(MealService::class.java)

    private val viewModel: DetailViewModel by viewModels()
    private lateinit var binding : DetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = DetailFragmentBinding.inflate(inflater)
        binding.data = viewModel
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        lifecycleScope.launchWhenResumed {
            // TODO: proper error handling
            val id = requireActivity().intent.getStringExtra(ID_EXTRA) ?: return@launchWhenResumed
            viewModel.meal.value = withContext(Dispatchers.IO) {
                service.lookup(id).meals.first()
            }
        }
    }
}