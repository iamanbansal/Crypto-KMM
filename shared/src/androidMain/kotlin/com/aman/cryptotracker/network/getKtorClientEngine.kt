package com.aman.cryptotracker.network

import io.ktor.client.engine.*
import io.ktor.client.engine.android.*

actual fun getKtorClientEngine(): HttpClientEngine = Android.create()
