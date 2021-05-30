package com.aman.cryptotracker.network

import com.aman.cryptotracker.entity.Data
import io.ktor.client.features.logging.*


/**
 * Created by Aman Bansal on 22/05/21.
 */
class CryptoRepository(private val api: CryptoApi) {


    @Throws(Exception::class)
    suspend fun getCryptoData(): List<Data> {

        val data = api.getCryptoData()

        if (data.status?.errorCode == 0) {
            return data.data!!
        } else {
            throw Exception("Api Error")
        }
    }


}