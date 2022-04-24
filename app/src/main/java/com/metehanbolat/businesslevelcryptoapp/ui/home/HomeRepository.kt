package com.metehanbolat.businesslevelcryptoapp.ui.home

import com.metehanbolat.businesslevelcryptoapp.base.BaseRepository
import com.metehanbolat.businesslevelcryptoapp.network.ApiFactory
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val apiFactory: ApiFactory
): BaseRepository() {

    suspend fun getData() = safeApiRequest { apiFactory.getData() }

}