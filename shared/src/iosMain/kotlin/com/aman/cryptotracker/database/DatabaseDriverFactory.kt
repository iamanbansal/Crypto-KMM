package com.aman.cryptotracker.database

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import database.CryptoDatabase


/**
 * Created by Aman Bansal on 31/05/21.
 */
actual class DatabaseDriverFactory() {

    companion object{
        const val DB_NAME = "crypto.dp"
    }

    actual fun createDrive():SqlDriver{
        return NativeSqliteDriver(CryptoDatabase.Schema, DB_NAME)
    }


}