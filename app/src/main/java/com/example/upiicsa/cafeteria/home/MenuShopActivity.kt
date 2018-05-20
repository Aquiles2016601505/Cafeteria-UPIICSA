package com.example.upiicsa.cafeteria.home

import android.arch.lifecycle.Observer
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.upiicsa.cafeteria.R
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.menu_shop_activity.*
import javax.inject.Inject


class MenuShopActivity :AppCompatActivity() {
    companion object {
        fun newIntent(context: Context) = Intent(context, MenuShopActivity::class.java)
    }

    @Inject
    lateinit var menuShopViewModel: MenuShopViewModel

    lateinit var orderListAdapter: MenuShopAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_shop_activity)
        loadDayMenu()


        orderListAdapter = MenuShopAdapter()
        orderListAdapter.onItemSelected = {

        }

        configureRecyclerView(orderListAdapter)

        menuShopViewModel.menuList.observe(this, orderListObserver)

    }

    private fun configureRecyclerView(adapter: MenuShopAdapter) {
        orderlistRecyclerView.setHasFixedSize(true)
        orderlistRecyclerView.isDrawingCacheEnabled = true;
        orderlistRecyclerView.layoutManager = LinearLayoutManager(this)
        orderlistRecyclerView.adapter = adapter
    }

    private val orderListObserver = Observer<List<MenuDescriptionModel>> {
        it?.let {
            orderListAdapter.replaceOrderList(it)
        }
    }

    fun loadDayMenu(){
        val requestOptions = RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .centerCrop()
        Glide.with(this)
                .load("https://cateringlacocinadeltrabajo.files.wordpress.com/2013/08/secretaria_nueva-01.jpg")
                .apply(requestOptions)
                .into(infoImageView)
        menuScoreRatingBar.rating = 5.0F
    }
}