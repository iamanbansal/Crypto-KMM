package com.aman.cryptotracker.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.aman.cryptotracker.entity.Data
import com.aman.cryptotracker.network.CryptoApi
import com.aman.cryptotracker.network.CryptoRepository
import com.aman.cryptotracker.viewmodel.CryptoViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState
import com.aman.cryptotracker.database.Database
import com.aman.cryptotracker.database.DatabaseDriverFactory


val viewModel = CryptoViewModel(CryptoRepository(CryptoApi(), Database(DatabaseDriverFactory())))


@Composable
fun App() {

    MaterialTheme {
        CryptoListView(viewModel)
    }

    viewModel.getCryptoData()
}

@Composable
fun CryptoListView(viewModel: CryptoViewModel) {
    val dataList by viewModel.list.collectAsState()

    return LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.fillMaxWidth()
    ) {

        items(dataList) { data ->

            CoinItem(data)
        }

    }
}

@Composable
fun CoinItem(data: Data) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)

    ) {
        Column(Modifier.padding(5.dp)) {

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {

                Text(
                    text = data.name.toString(),
                    modifier = Modifier.padding(2.dp),
                    style = MaterialTheme.typography.h5
                )
                Text(text = "$${data.quote?.uSD?.price?.toFloat()}")
            }
            Spacer(modifier = Modifier.padding(4.dp))
            Text(text = "${data.symbol}")
        }

    }
}