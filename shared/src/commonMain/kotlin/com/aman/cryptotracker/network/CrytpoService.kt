package com.aman.cryptotracker.network

import com.aman.cryptotracker.entity.Data


/**
 * Created by Aman Bansal on 22/05/21.
 */
class CrytpoService(private val api: CryptoApi) {


    suspend fun getCryptoData(): List<Data> {

        val data = api.getCryptoData()

        if (data.status?.errorCode == 0) {
            return data.data!!
        } else {
            throw Exception("Api Error")
        }
    }


}