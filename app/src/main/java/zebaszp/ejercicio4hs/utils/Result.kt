package zebaszp.ejercicio4hs.utils

sealed class Result<out R> {
    companion object {
        // For extension purposes
    }
}

data class Success<out T>(val data: T) : Result<T>()
data class Error(val exception: Exception) : Result<Nothing>()
object Loading : Result<Nothing>()


inline fun <R> Result.Companion.tryCatching(block: () -> R) : Result<R> = try {
    Success(block())
} catch (e: Exception) {
    Error(e)
}
