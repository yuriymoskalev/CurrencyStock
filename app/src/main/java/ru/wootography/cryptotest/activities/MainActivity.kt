package ru.wootography.cryptotest.activities


import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.main_activity_content.*

import ru.wootography.cryptotest.R
import ru.wootography.cryptotest.adapters.StockAdapter
import ru.wootography.cryptotest.interfaces.views.MainView
import ru.wootography.cryptotest.models.StockItems
import ru.wootography.cryptotest.presenters.MainActivityPresenter
import ru.wootography.cryptotest.utils.Injector

class MainActivity : BaseActivity(), MainView, NavigationView.OnNavigationItemSelectedListener {

    lateinit var stockAdapter : StockAdapter

    companion object {
        private val LAYOUT = R.layout.activity_main
    }


    @InjectPresenter
    lateinit var mainPresenter: MainActivityPresenter

    @ProvidePresenter
    internal fun provideMainActivityPresenter(): MainActivityPresenter {
        return Injector.presenterComponent!!.mainActivityPresenter
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(LAYOUT)
        setSupportActionBar(toolbar)

        setupUI()
        setupUX()
    }

    override fun setStockList(stockList: StockItems) {
       stockAdapter = StockAdapter(stockList)
       rv_stock_list.adapter = stockAdapter

    }


    override fun setupUI() {
        rv_stock_list.layoutManager = LinearLayoutManager(this)



    }

    override fun setupUX() {

        val toggle = ActionBarDrawerToggle(
        this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        mainPresenter.getStocksItems()
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> {
                mainPresenter.getStocksItems()
                return true}
            else -> return super.onOptionsItemSelected(item)
        }
    }


}
