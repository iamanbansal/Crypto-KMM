package com.aman.cryptotracker.network

import com.aman.cryptotracker.entity.CryptoResponse
import com.aman.cryptotracker.network.ApiKey.COIN_MARKET_KEY
import io.ktor.client.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import kotlinx.serialization.json.Json

/**
 * Created by Aman Bansal on 22/05/21.
 */
class CryptoApi {

    private val httpClient by lazy {

        HttpClient {

            install(JsonFeature) {
                val json = Json {
                    ignoreUnknownKeys = true
                }

                serializer = KotlinxSerializer(json)
            }
        }
    }


    suspend fun getCryptoData(limit:Int = DEFAULT_LIMIT):CryptoResponse {

       return httpClient.get(URL){
            parameter("start", 1)
            parameter("limit", limit)
            parameter("convert", "USD")

            headers {
                append("X-CMC_PRO_API_KEY",COIN_MARKET_KEY)
            }

        }
    }

    companion object{
        private const val DEFAULT_LIMIT = 50
        private const val URL = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest"
    }
}