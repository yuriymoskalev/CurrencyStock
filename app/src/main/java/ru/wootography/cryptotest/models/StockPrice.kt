package ru.wootography.cryptotest.models

import com.google.gson.annotations.SerializedName

data class StockPrice (
        @SerializedName("currency") val currency : String,
        @SerializedName("amount") val amount : Double
)