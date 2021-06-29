package com.aman.cryptotracker.database

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import database.CryptoDatabase
import android.app.Application


/**
 * Created by Aman Bansal on 31/05/21.
 */

actual class DatabaseDriverFactory {


    companion object{
        const val DB_NAME = "crypto.dp"
        lateinit var application: Application
    }


    actual fun createDrive():SqlDriver {
        return  AndroidSqliteDriver(CryptoDatabase.Schema, application, DB_NAME)
    }
}