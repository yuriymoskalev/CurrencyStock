package ru.wootography.cryptotest.api

import com.google.gson.annotations.SerializedName

class ApiResponse<T> {
    @SerializedName("stock")
    var data: T? = null

//    @SerializedName("metadata")
//    var metadata: T? = null

}
