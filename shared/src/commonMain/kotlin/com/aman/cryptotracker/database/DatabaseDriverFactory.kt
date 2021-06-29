package com.aman.cryptotracker.database

import com.squareup.sqldelight.db.SqlDriver


/**
 * Created by Aman Bansal on 31/05/21.
 */
expect class DatabaseDriverFactory {

    fun createDrive():SqlDriver

}
