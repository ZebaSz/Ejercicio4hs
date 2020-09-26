package zebaszp.ejercicio4hs.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import zebaszp.ejercicio4hs.databinding.DetailFragmentBinding


class DetailFragment : Fragment() {

    private val viewModel: DetailViewModel by viewModels()
    private lateinit var binding : DetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = DetailFragmentBinding.inflate(inflater)
        binding.data = viewModel
        return binding.root
    }
}