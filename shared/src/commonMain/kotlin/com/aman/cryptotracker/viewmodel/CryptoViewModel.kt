package com.aman.cryptotracker.viewmodel

import com.aman.cryptotracker.entity.Data
import com.aman.cryptotracker.network.CryptoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


/**
 * Created by Aman Bansal on 30/05/21.
 */

/**
*  This is not actual android AAC ViewModel. I couldn't think of better so I used this :p
*/
class CryptoViewModel (private val cryptoRepository:CryptoRepository) {


    private val mainScope = CoroutineScope(SupervisorJob())
    private val _list = MutableStateFlow<List<Data>>(emptyList())
    val list:StateFlow<List<Data>> = _list

    fun getCryptoData(){

        mainScope.launch {

            try {
                val data = cryptoRepository.getCryptoData()
                 _list.value = data

            } catch (e: Exception) {
                e.printStackTrace()
                //todo handle error
            }
        }

    }
}