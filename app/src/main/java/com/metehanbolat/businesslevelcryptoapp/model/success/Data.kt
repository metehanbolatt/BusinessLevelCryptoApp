package com.metehanbolat.businesslevelcryptoapp.model.success

data class Data(
    val date_added: String?,
    val id: Int?,
    val last_updated: String?,
    val name: String?,
    val platform: Any?,
    val quote: Quote?,
    val self_reported_circulating_supply: Any?,
    val self_reported_market_cap: Any?,
    val slug: String?,
    val symbol: String?,
    val tags: List<String>?,
)