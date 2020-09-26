package zebaszp.ejercicio4hs.ui.main

import retrofit2.http.GET
import retrofit2.http.Query
import zebaszp.ejercicio4hs.domain.MealSearchResult

interface MealService {
    @GET("/api/json/v1/1/search.php")
    suspend fun search(@Query("s") searchTerm: String): MealSearchResult
}
