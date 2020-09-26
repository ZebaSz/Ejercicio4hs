package zebaszp.ejercicio4hs.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import zebaszp.ejercicio4hs.R

internal const val ID_EXTRA = "mealId"

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)
    }

    companion object {
        fun createIntent(context: Context, mealId: String) = Intent(context, DetailActivity::class.java).apply {
            putExtra(ID_EXTRA, mealId)
        }
    }
}