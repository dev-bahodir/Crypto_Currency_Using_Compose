package dev.bahodir.cryptocurrencyapp.domain.use_case.get_coin

import dev.bahodir.cryptocurrencyapp.common.Resource
import dev.bahodir.cryptocurrencyapp.data.remote.dto_detail.toCoinDetail
import dev.bahodir.cryptocurrencyapp.domain.model.CoinDetail
import dev.bahodir.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>("Could not reach server. Check your internet connection"))
        }
    }
}