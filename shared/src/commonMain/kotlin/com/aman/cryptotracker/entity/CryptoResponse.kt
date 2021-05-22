package com.aman.cryptotracker.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * Created by Aman Bansal on 16/05/21.
 */
@Serializable
data class CryptoResponse(
    @SerialName("data")
    val `data`: List<Data>?,
    @SerialName("status")
    val status: Status?
)


@Serializable
data class Data(
    @SerialName("id")
    val id: Int?,
    @SerialName("name")
    val name: String?,
    @SerialName("symbol")
    val symbol: String?,
    @SerialName("slug")
    val slug: String?,
    @SerialName("num_market_pairs")
    val numMarketPairs: Int?,
    @SerialName("date_added")
    val dateAdded: String?,
    @SerialName("tags")
    val tags: List<String>?,
    @SerialName("max_supply")
    val maxSupply: Double?,
    @SerialName("circulating_supply")
    val circulatingSupply: Double?,
    @SerialName("total_supply")
    val totalSupply: Double?,
    @SerialName("cmc_rank")
    val cmcRank: Int?,
    @SerialName("last_updated")
    val lastUpdated: String?,
    @SerialName("quote")
    val quote: Quote?
)

@Serializable
data class Status(
    @SerialName("credit_count")
    val creditCount: Int?,
    @SerialName("elapsed")
    val elapsed: Int?,
    @SerialName("error_code")
    val errorCode: Int?,
    @SerialName("error_message")
    val errorMessage: String?,
    @SerialName("notice")
    val notice: String?,
    @SerialName("timestamp")
    val timestamp: String?,
    @SerialName("total_count")
    val totalCount: Int?
)

@Serializable
data class Quote(
    @SerialName("USD")
    val uSD: USD?
)

@Serializable
data class USD(
    @SerialName("price")
    val price: Double?,
    @SerialName("volume_24h")
    val volume24h: Double?,
    @SerialName("percent_change_1h")
    val percentChange1h: Double?,
    @SerialName("percent_change_24h")
    val percentChange24h: Double?,
    @SerialName("percent_change_7d")
    val percentChange7d: Double?,
    @SerialName("percent_change_30d")
    val percentChange30d: Double?,
    @SerialName("percent_change_60d")
    val percentChange60d: Double?,
    @SerialName("percent_change_90d")
    val percentChange90d: Double?,
    @SerialName("market_cap")
    val marketCap: Double?,
    @SerialName("last_updated")
    val lastUpdated: String?
)


