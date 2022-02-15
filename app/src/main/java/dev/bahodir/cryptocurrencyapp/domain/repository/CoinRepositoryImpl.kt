package dev.bahodir.cryptocurrencyapp.domain.repository

import dev.bahodir.cryptocurrencyapp.data.remote.CoinPaprikaApi
import dev.bahodir.cryptocurrencyapp.data.remote.dto.CoinDto
import dev.bahodir.cryptocurrencyapp.data.remote.dto_detail.CoinDetailDto
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }

}