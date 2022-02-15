package dev.bahodir.cryptocurrencyapp.data.remote

import dev.bahodir.cryptocurrencyapp.data.remote.dto.CoinDto
import dev.bahodir.cryptocurrencyapp.data.remote.dto_detail.CoinDetailDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}