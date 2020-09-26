package zebaszp.ejercicio4hs.ui.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import zebaszp.ejercicio4hs.domain.Meal
import zebaszp.ejercicio4hs.domain.MealSearchResult
import zebaszp.ejercicio4hs.domain.MealService
import zebaszp.ejercicio4hs.utils.Loading
import zebaszp.ejercicio4hs.utils.Success

class MainViewModelTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `request should be performed when search term is updated`() {
        val service = mockk<MealService>()
        val serviceResponse = listOf<Meal>(mockk())
        coEvery { service.search(any()) } coAnswers {
            delay(500)
            MealSearchResult(serviceResponse)
        }
        val vm = MainViewModel(service)
        val newTerm = "newSearchTerm"

        var loading = false
        var count = 0
        vm.results.observeForever {
            ++count
            if (loading) {
                assertEquals(Loading, it)
                loading = false
            } else {
                assertEquals(Success(serviceResponse), it)
            }
        }

        loading = true
        vm.searchTerm.value = newTerm

        runBlocking {
            delay(1000)
        }
        assertEquals(2, count)
        coVerify {
            service.search(newTerm)
        }
    }
}