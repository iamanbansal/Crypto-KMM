
This is the codebase of Crypto currency Tracking Kotlin Multiplatform App.


# Components
#### Shared Components
1. Ktor (Network Client)
1. SQL Delight (Local DB)

#### Android Specific Components
1. Jetpack Compose

#### iOS Specific Components
- SwiftUI (PRs are welcome)

#### JVM Specific Components
- Jetpack compose for desktop

### TODOs
- Local DB implementation
- SwiftUI
- Jetpack compose for desktop


<img class='header-img' src="https://github.com/iamanbansal/Crypto-KMM/blob/main/media/structure.png?raw=true" />
<br>


### Android Studio Version
I've been using "Android Studio Arctic Fox (2020.3.1) Canary 8".


### Kotlin Version
1.5

### Setup
- This project is using [CoinMarketCap](https://coinmarketcap.com/)'s API to get coins' data. Get your API key from [here](https://coinmarketcap.com/api/)
- Then create file in `ApiKey` in `com.aman.cryptotracker.network` in `shared` module

```
object ApiKey {
    const val COIN_MARKET_KEY = "Your API key"
}
```