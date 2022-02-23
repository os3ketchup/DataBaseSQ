package com.example.databasesq.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.databasesq.adapter.models.User
import com.example.databasesq.databinding.ItemRvBinding

class MyDataBaseAdapter(val list: List<User>):RecyclerView.Adapter<MyDataBaseAdapter.VH>() {

    inner class VH(private var itemRV: ItemRvBinding):RecyclerView.ViewHolder(itemRV.root){
        fun onBind(user: User){
            itemRV.tvItemName.text = user.name
            itemRV.tvItemAge.text = user.age.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemRvBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}