package com.metehanbolat.businesslevelcryptoapp.network

import com.metehanbolat.businesslevelcryptoapp.model.success.CryptoResponse
import com.metehanbolat.businesslevelcryptoapp.utils.Constants.API_KEY
import com.metehanbolat.businesslevelcryptoapp.utils.Constants.LIMIT
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiFactory {

    // https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest?limit=10

    @GET("v1/cryptocurrency/listings/latest")
    suspend fun getData(
        @Header("X-CMC_PRO_API_KEY") apiKey: String = API_KEY,
        @Query("limit") limit: String = LIMIT
    ): CryptoResponse
}