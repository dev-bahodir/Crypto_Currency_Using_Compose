package dev.bahodir.cryptocurrencyapp.domain.model

import dev.bahodir.cryptocurrencyapp.data.remote.dto.CoinDto

data class Coin(
    val id: String,
    val is_active: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)
