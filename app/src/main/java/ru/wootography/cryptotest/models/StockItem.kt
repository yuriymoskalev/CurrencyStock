package ru.wootography.cryptotest.models

import com.google.gson.annotations.SerializedName

data class StockItem (
        @SerializedName("name") val name : String,
        @SerializedName("price") val price : StockPrice,
        @SerializedName("percent_change") val percent_change : Double,
        @SerializedName("volume") val volume : Int,
        @SerializedName("symbol") val symbol : String
)