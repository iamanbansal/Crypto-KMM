package com.aman.cryptotracker.network

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin


actual fun getKtorClientEngine(): HttpClientEngine = Darwin.create()