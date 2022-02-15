package dev.bahodir.cryptocurrencyapp.di

import androidx.compose.ui.unit.Constraints
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.bahodir.cryptocurrencyapp.common.Constants
import dev.bahodir.cryptocurrencyapp.data.remote.CoinPaprikaApi
import dev.bahodir.cryptocurrencyapp.domain.repository.CoinRepository
import dev.bahodir.cryptocurrencyapp.domain.repository.CoinRepositoryImpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApi {
        return Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }
}