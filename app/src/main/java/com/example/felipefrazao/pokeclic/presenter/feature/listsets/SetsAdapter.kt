package com.example.felipefrazao.pokeclic.presenter.feature.listsets

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.felipefrazao.pokeclic.R
import com.example.felipefrazao.pokeclic.domain.model.Set
import com.example.felipefrazao.pokeclic.presenter.feature.getcard.CardActivity
import com.example.felipefrazao.pokeclic.presenter.feature.listcards.ListCardsActivity
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


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var imgSet: ImageView
        var tvSetName: TextView
        var tvSetCards: TextView
        var tvReleaseDate: TextView
        var tvDateLabel: TextView
        var tvAmoCards: TextView
        var setCode = ""

        init {
            imgSet = itemView.findViewById(R.id.img_set_logo)
            tvSetName = itemView.findViewById(R.id.tv_set_name)
            tvSetCards = itemView.findViewById(R.id.tv_cards_amo)
            tvReleaseDate = itemView.findViewById(R.id.tv_release_date)
            tvDateLabel = itemView.findViewById(R.id.tv_date_label)
            tvAmoCards = itemView.findViewById(R.id.tv_amo_cards_label)

            itemView.setOnClickListener(this)
        }

        fun setData(set:Set){
            Picasso.with(context).load(set.logoUrl).into(imgSet)
            tvSetName.text = set.name
            tvSetCards.text = set.totalCards.toString()
            tvReleaseDate.text = set.releaseDate
            tvDateLabel.text = context.getString(R.string.dateLabel)
            tvAmoCards.text = context.getString(R.string.cardsAmountLabel)
            setCode = set?.code!!

        }

        override fun onClick(v: View?) {
            // onItemClick.invoke()
            var intent  = Intent(v?.context, ListCardsActivity::class.java)
            intent.putExtra("setCode",  setCode)
            v?.context!!.startActivity(intent)
        }
    }
}