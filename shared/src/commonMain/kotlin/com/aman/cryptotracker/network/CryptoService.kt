package com.aman.cryptotracker.network

import com.aman.cryptotracker.entity.Data


/**
 * Created by Aman Bansal on 22/05/21.
 */
class CryptoService(private val api: CryptoApi) {


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