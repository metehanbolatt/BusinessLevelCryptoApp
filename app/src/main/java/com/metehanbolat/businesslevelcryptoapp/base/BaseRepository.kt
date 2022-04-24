package com.metehanbolat.businesslevelcryptoapp.base

import com.google.gson.Gson
import com.metehanbolat.businesslevelcryptoapp.model.error.ErrorResponse
import com.metehanbolat.businesslevelcryptoapp.utils.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

abstract class BaseRepository {

    suspend fun <T> safeApiRequest(
        apiRequest: suspend () -> T
    ): NetworkResult<T> {
        return withContext(Dispatchers.IO) {
            try {
                NetworkResult.Success(apiRequest.invoke())
            } catch (e: Exception) {
                when(e) {
                    is HttpException -> {
                        NetworkResult.Error(networkError = false, message = errorBodyParser(e.localizedMessage))
                    }
                    else -> NetworkResult.Error(networkError = true, message = e.localizedMessage)
                }
            }
        }
    }

}

private fun errorBodyParser(error: String?): String {
    error?.let {
        return try {
            val errorResponse = Gson().fromJson(error, ErrorResponse::class.java)
            val errorMessage = errorResponse.status?.error_message
            errorMessage ?: "Unknown Error"
        } catch (e: Exception) {
            "Unknown Error"
        }
    }
    return "Unknown Error"
}