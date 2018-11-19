package com.example.felipefrazao.pokeclic.presenter.feature.listsets

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.felipefrazao.pokeclic.R
import com.example.felipefrazao.pokeclic.domain.model.Set
import com.squareup.picasso.Picasso

class SetsAdapter(private val context: Context,
                  private val sets: List<Set>):RecyclerView.Adapter<SetsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val v = LayoutInflater.from(context).inflate(R.layout.iten_set,parent,false)

        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return sets.size
    }

    override fun onBindViewHolder(holder: SetsAdapter.ViewHolder, position: Int) {
        holder.setData(sets[position])

    }


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var imgSet: ImageView
        var tvSetName: TextView
        var tvSetCards: TextView
        var tvReleaseDate: TextView

        init {
            imgSet = itemView.findViewById(R.id.img_set_logo)
            tvSetName = itemView.findViewById(R.id.tv_set_name)
            tvSetCards = itemView.findViewById(R.id.tv_cards_amo)
            tvReleaseDate = itemView.findViewById(R.id.tv_release_date)
        }

        fun setData(set:Set){
            Picasso.with(context).load(set.logoUrl).into(imgSet)
            tvSetName.text = set.name
            tvSetCards.text =set.totalCards.toString()
            tvReleaseDate.text = set.releaseDate

        }
    }
}