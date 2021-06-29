package com.aman.cryptotracker.network

import com.aman.cryptotracker.database.Database
import com.aman.cryptotracker.entity.Data
import database.CryptoDatabase
import io.ktor.client.features.logging.*
import kotlinx.coroutines.flow.flow


/**
 * Created by Aman Bansal on 22/05/21.
 */
class CryptoRepository(private val api: CryptoApi, private val cryptoDatabase: Database) {


    @Throws(Exception::class)
    suspend fun getCryptoData() = flow<List<Data>>{

        val cache = cryptoDatabase.getAllCoinData()

        emit(cache)

        val data = api.getCryptoData()


        if (data.status?.errorCode == 0 && data.data != null) {
            emit(data.data)
            data.data.forEach {
                cryptoDatabase.insertData(it)
            }
        } else {
            throw Exception("Api Error")
        }
    }


}