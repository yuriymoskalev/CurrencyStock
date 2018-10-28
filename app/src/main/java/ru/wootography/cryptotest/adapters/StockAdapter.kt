package ru.wootography.cryptotest.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.item_for_list.view.*
import ru.wootography.cryptotest.R
import ru.wootography.cryptotest.models.StockItem
import ru.wootography.cryptotest.models.StockItems
import java.math.BigDecimal
import java.math.BigDecimal.ROUND_HALF_UP
import java.text.DecimalFormat

class StockAdapter (private val stocks: StockItems) : RecyclerView.Adapter<StockAdapter.StockVH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockAdapter.StockVH {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_for_list, parent, false)
        return StockVH(itemView = itemView)
    }

    override fun onBindViewHolder(holder: StockVH, position: Int) {
        holder.bind(stocks[position])
    }

    override fun getItemCount(): Int {
        return stocks.size
    }

    class StockVH(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val stockName by lazy {itemView.findViewById<TextView>(R.id.tv_stock_name)}
        private val stockVolume by lazy {itemView.findViewById<TextView>(R.id.tv_stock_volume)}
        private val stockAmount by lazy {itemView.findViewById<TextView>(R.id.tv_stock_amount)}

        fun bind(stock: StockItem){
            stockName.text = stock.name
            stockVolume.text = stock.volume.toString()

            val bigDecAmount = BigDecimal(stock.price.amount)
            val df = DecimalFormat("#,##0.00")

            bigDecAmount.setScale(2, ROUND_HALF_UP)
            stockAmount.text = df.format(bigDecAmount)
        }

    }

}