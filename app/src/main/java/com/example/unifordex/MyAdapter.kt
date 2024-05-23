package com.example.unifordex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val exposicoesList:ArrayList<Exposicoes>) : RecyclerView.Adapter<MyAdapter.MyViewHolde>() {
    class MyViewHolde(itemView:View): RecyclerView.ViewHolder(itemView){
        val tvnome: TextView = itemView.findViewById(R.id.txt_nome_card_expo)
        val tvano: TextView = itemView.findViewById(R.id.txt_ano_card_expo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolde {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_expo,parent,false)
        return MyViewHolde(itemView)
    }

    override fun getItemCount(): Int {
        return exposicoesList.size
    }

    override fun onBindViewHolder(holder: MyViewHolde, position: Int) {
        holder.tvnome.text = exposicoesList[position].nome
        holder.tvano.text = exposicoesList[position].ano
    }
}