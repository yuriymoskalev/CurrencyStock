package ru.wootography.cryptotest.presenters

import com.arellomobile.mvp.InjectViewState
import ru.wootography.cryptotest.Const
import ru.wootography.cryptotest.api.ApiResponse
import ru.wootography.cryptotest.api.RestApi
import ru.wootography.cryptotest.interfaces.views.MainView
import ru.wootography.cryptotest.models.StockItems
import ru.wootography.cryptotest.utils.RxUtils
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@InjectViewState
class MainActivityPresenter @Inject
internal constructor(private val restApi: RestApi) : BasePresenter<MainView>() {


    init {
        getStocksItems()
    }


     fun getStocksItems() {
        val request = restApi.istock.getAll()
                .repeatWhen { objectObservable -> objectObservable.delay(Const.Url.DELAY, TimeUnit.SECONDS)  }
                .compose(RxUtils.httpSchedulers())
                .subscribe(
                        { response -> successGetList(response) },
                        { error -> handleError(error) }

                )
        unSubscribeOnDestroy(request)
    }

    private fun handleError(error: Throwable?) {

    }

    private fun successGetList(response: ApiResponse<StockItems>) {
        val stockList = response.data
        viewState.setStockList(stockList!!)
    }

}


