package com.example.upiicsa.cafeteria.home

import android.graphics.Color
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.upiicsa.cafeteria.R
import kotlinx.android.synthetic.main.menu_shop_list_item.view.*


class MenuShopAdapter : RecyclerView.Adapter<MenuShopAdapter.ViewHolder>() {

        var onItemSelected: ((MenuDescriptionModel) -> Unit)? = null

        private val menuList = ArrayList<MenuDescriptionModel>()

        override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
            holder?.bind(menuList[position])
        }

        override fun getItemCount() = menuList.size

        override fun getItemId(position: Int) = position.toLong()

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.menu_shop_list_item, parent, false) as View)
        }

        inner class ViewHolder(view: View?) : RecyclerView.ViewHolder(view) {
            init {
                itemView.setOnClickListener({
                    onItemSelected?.invoke(menuList.get(adapterPosition))
                })
            }

            fun bind(menuItem: MenuDescriptionModel) {
                itemView.titleTextView.text = menuItem.name
                itemView.precieTextView.text = menuItem.price
                itemView.descriptionTextView.text = menuItem.description
            }
        }

        fun replaceOrderList(orderList: List<MenuDescriptionModel>) {
            val diffResult = DiffUtil.calculateDiff(DiffCallback(this.menuList, orderList))

            this.menuList.clear()
            this.menuList.addAll(orderList)

            diffResult.dispatchUpdatesTo(this)
        }

        class DiffCallback(val oldList: List<MenuDescriptionModel>, val newList: List<MenuDescriptionModel>) : DiffUtil.Callback() {
            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) = oldList[oldItemPosition].id == newList[newItemPosition].id
            override fun getOldListSize() = oldList.size
            override fun getNewListSize() = newList.size
            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = oldList[oldItemPosition] == newList[newItemPosition]
        }
}