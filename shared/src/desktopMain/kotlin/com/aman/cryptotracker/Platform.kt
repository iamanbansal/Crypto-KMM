package com.aman.cryptotracker

actual class Platform actual constructor() {
    actual val platform: String
        get() = "Desktop"
}