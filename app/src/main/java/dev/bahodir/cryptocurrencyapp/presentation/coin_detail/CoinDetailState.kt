package dev.bahodir.cryptocurrencyapp.presentation.coin_detail

import dev.bahodir.cryptocurrencyapp.domain.model.Coin
import dev.bahodir.cryptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
