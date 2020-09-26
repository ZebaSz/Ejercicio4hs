package zebaszp.ejercicio4hs.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import zebaszp.ejercicio4hs.databinding.ItemMealBinding
import zebaszp.ejercicio4hs.domain.Meal

class MainRecyclerAdapter(private val data: List<Meal>) : RecyclerView.Adapter<MealViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemMealBinding.inflate(layoutInflater, parent, false)
        return MealViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) =
        holder.bind(data[position])

    override fun getItemCount() =
        data.size
}

class MealViewHolder(private val binding: ItemMealBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(meal: Meal) {
        binding.meal = meal
        Picasso.get().load(meal.thumbUri).into(binding.mealThumb)
        binding.executePendingBindings()
    }
}
