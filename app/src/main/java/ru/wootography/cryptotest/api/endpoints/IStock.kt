package ru.wootography.cryptotest.api.endpoints

import io.reactivex.Observable
import retrofit2.http.GET
import ru.wootography.cryptotest.api.ApiResponse
import ru.wootography.cryptotest.models.StockItems

interface IStock {
    @GET("stocks.json")
    fun getAll(): Observable<ApiResponse<StockItems>>
}