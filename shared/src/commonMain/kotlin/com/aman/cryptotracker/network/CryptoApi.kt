package com.aman.cryptotracker.network

import com.aman.cryptotracker.entity.CryptoResponse
import com.aman.cryptotracker.network.ApiKey.COIN_MARKET_KEY
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

/**
 * Created by Aman Bansal on 22/05/21.
 */
class CryptoApi {

    private val httpClient by lazy {
        HttpClient(getKtorClientEngine()) {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                })
            }

        }
    }


    suspend fun getCryptoData(limit: Int = DEFAULT_LIMIT): CryptoResponse =
        withContext(Dispatchers.Default) {

            return@withContext httpClient.get(URL) {
                parameter("start", 1)
                parameter("limit", limit)
                parameter("convert", "USD")

                headers {
                    append("X-CMC_PRO_API_KEY", COIN_MARKET_KEY)
                }

            }.body()
        }

    companion object {
        private const val DEFAULT_LIMIT = 50
        private const val URL =
            "https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest"
    }
}