package com.aman.cryptotracker.database

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver
import database.CryptoDatabase
import database.CryptoDatabase.Companion.Schema

/**
 * Created by Aman Bansal on 31/05/21.
 */

actual class DatabaseDriverFactory() {
    actual fun createDrive(): SqlDriver {
        val driver: SqlDriver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
        CryptoDatabase.Schema.create(driver)
        return driver
    }

}