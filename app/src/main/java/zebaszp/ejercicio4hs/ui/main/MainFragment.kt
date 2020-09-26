package zebaszp.ejercicio4hs.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import zebaszp.ejercicio4hs.R
import zebaszp.ejercicio4hs.databinding.MainFragmentBinding
import zebaszp.ejercicio4hs.utils.Error
import zebaszp.ejercicio4hs.utils.Loading
import zebaszp.ejercicio4hs.utils.Success


class MainFragment : Fragment() {
    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModels(factoryProducer = ::MainViewModelFactory)
    private lateinit var binding : MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = MainFragmentBinding.inflate(inflater)
        binding.data = viewModel
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.results.observe(requireActivity()) {
            when (it) {
                is Success -> {
                    binding.loading.visibility = View.GONE
                    binding.resultsList.visibility = View.VISIBLE
                    binding.resultsList.adapter = MainRecyclerAdapter(it.data)
                }
                is Error -> TODO()
                Loading -> {
                    binding.resultsList.visibility = View.GONE
                    binding.loading.visibility = View.VISIBLE
                }
            }
        }
    }

}