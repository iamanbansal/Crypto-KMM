package com.aman.cryptotracker

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.aman.cryptotracker.entity.Data
import com.aman.cryptotracker.network.CryptoApi
import com.aman.cryptotracker.network.CryptoService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private val scope = CoroutineScope(Dispatchers.Main)
    private val service = CryptoService(CryptoApi())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                val dataList = remember { mutableStateOf<List<Data>>(emptyList()) }
                scope.launch {
                    dataList.value = service.getCryptoData()
                }

                CryptoListView(list = dataList.value)
            }

        }
    }
}

@Composable
fun CryptoListView(list: List<Data>) {
    return LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.fillMaxWidth()
    ) {

        items(list) { data ->

            CoinItem(data = data)
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
                    modifier = Modifier.padding(2.dp)
                )
                Text(text = "$${data.quote?.uSD?.price?.toFloat()}")
            }
            Spacer(modifier = Modifier.padding(4.dp))
            Text(text = "${data.symbol}")
        }

    }
}
