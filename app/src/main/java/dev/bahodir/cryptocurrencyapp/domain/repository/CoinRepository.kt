package dev.bahodir.cryptocurrencyapp.domain.repository

import dev.bahodir.cryptocurrencyapp.data.remote.dto.CoinDto
import dev.bahodir.cryptocurrencyapp.data.remote.dto_detail.CoinDetailDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}