package com.example.felipefrazao.pokeclic.presenter.listcards

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.TextView
import com.example.felipefrazao.pokeclic.R
import com.example.felipefrazao.pokeclic.domain.model.Card
import com.example.felipefrazao.pokeclic.presenter.getCard.CardActivity

class CardsAdpter(

    private val context: Context,
    private val cards: List<Card>
    //private val onItemClick: () -> Unit

) : RecyclerView.Adapter<CardsAdpter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): CardsAdpter.ViewHolder {

        val v = LayoutInflater.from(context)
            .inflate(R.layout.iten_card, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return cards.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.preencher(cards[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), OnClickListener {


        var tvCard: TextView
        var cardId: String = ""

        init {
            tvCard = itemView.findViewById(R.id.tv_card)

            itemView.setOnClickListener(this)
        }

        fun preencher(card: Card) {
            tvCard.text = card.name.replace("-EX", "").replace("ex", "")
            cardId = card.id
        }

        override fun onClick(v: View?) {
           // onItemClick.invoke()
            var intent  = Intent(v?.context, CardActivity::class.java)
            intent.putExtra("CardId", cardId)
            v?.context!!.startActivity(intent)
        }

    }
}