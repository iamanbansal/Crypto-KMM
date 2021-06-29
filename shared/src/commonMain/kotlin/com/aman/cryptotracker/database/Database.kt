package com.aman.cryptotracker.database

import com.aman.cryptotracker.entity.Data
import database.CryptoDatabase
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.random.Random


/**
 * Created by Aman Bansal on 31/05/21.
 */
class Database(private val driverFactory: DatabaseDriverFactory) {

    private val db = CryptoDatabase(driverFactory.createDrive())
    private val dbQuery = db.cryptoDatabaseQueries


    internal fun insertData(data: Data) = with(data){
        if (id == null)return@with

        dbQuery.insertCoinData(
            id.toLong(),
            name,
            symbol,
            slug,
            numMarketPairs?.toLong(),
            dateAdded,
            Json.encodeToString(tags),
            maxSupply,
            circulatingSupply,
            totalSupply,
            cmcRank?.toLong(),
            lastUpdated,
            Json.encodeToString(quote)

        )
    }


    internal fun getAllCoinData(): List<Data> {
        return dbQuery.getAllCoinData(::mapper).executeAsList()
    }

    private fun mapper(
        id: Long,
        name: String?,
        symbol: String?,
        slug: String?,
        numMarketPairs: Long?,
        dateAdded: String?,
        tags: String?,
        maxSupply: Double?,
        circulatingSupply: Double?,
        totalSupply: Double?,
        cmcRank: Long?,
        lastUpdated: String?,
        quote: String?
    ): Data {
        return Data(
            id.toInt(),
            name,
            symbol,
            slug,
            numMarketPairs?.toInt(),
            dateAdded,
            tags?.let { Json.decodeFromString<List<String>>(tags) },
            maxSupply,
            circulatingSupply,
            totalSupply,
            cmcRank?.toInt(),
            lastUpdated,
            quote?.let { Json.decodeFromString(it) }
        )
    }
}