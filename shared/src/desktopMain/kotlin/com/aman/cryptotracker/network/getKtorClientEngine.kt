package com.aman.cryptotracker.network

import io.ktor.client.engine.*
import io.ktor.client.engine.java.*

actual fun getKtorClientEngine(): HttpClientEngine = Java.create()