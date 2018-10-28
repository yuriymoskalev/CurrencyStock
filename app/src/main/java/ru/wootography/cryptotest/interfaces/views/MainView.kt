package ru.wootography.cryptotest.interfaces.views

import ru.wootography.cryptotest.models.StockItems

interface MainView : BaseView {
    fun setStockList(stockList: StockItems)


}
