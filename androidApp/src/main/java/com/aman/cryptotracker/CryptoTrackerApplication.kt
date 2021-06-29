package com.aman.cryptotracker


import android.app.Application
import com.aman.cryptotracker.database.DatabaseDriverFactory
import com.aman.cryptotracker.yo.Hello


class CryptoTrackerApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        DatabaseDriverFactory.application = this
    }

}