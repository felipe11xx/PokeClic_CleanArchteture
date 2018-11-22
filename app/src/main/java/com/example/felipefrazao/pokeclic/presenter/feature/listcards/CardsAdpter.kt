package com.example.felipefrazao.pokeclic.presenter.feature.listcards

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.felipefrazao.pokeclic.R
import com.example.felipefrazao.pokeclic.domain.model.Card
import com.example.felipefrazao.pokeclic.domain.model.RetreatCost
import com.squareup.picasso.Picasso

class CardsAdpter(

    private val context: Context,
    private val cards: List<Card>,
    private val onItemClick: (cardId:String) -> Unit

) : RecyclerView.Adapter<CardsAdpter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder {

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
        var tvCardSet: TextView
        var tvSetNum: TextView
        var tvRetreat: TextView
        var imgCard: ImageView
        var viewGroupRetreatCost: LinearLayout

      /*  var imgEnergy1: ImageView
        var imgEnergy2: ImageView
        var imgEnergy3: ImageView
        var imgEnergy4: ImageView
        var imgEnergy5: ImageView*/

        var cardId: String = ""

        init {
            tvCard = itemView.findViewById(R.id.tv_card_name)
            tvCardSet = itemView.findViewById(R.id.tv_set_name)
            tvSetNum = itemView.findViewById(R.id.tv_set_num)
            tvRetreat = itemView.findViewById(R.id.tv_retreat)
            imgCard = itemView.findViewById(R.id.img_card)
            viewGroupRetreatCost = itemView.findViewById(R.id.viewGroupRetreatCost)

          /*  imgEnergy1 = itemView.findViewById(R.id.img_retreat_1)
            imgEnergy2 = itemView.findViewById(R.id.img_retreat_2)
            imgEnergy3 = itemView.findViewById(R.id.img_retreat_3)
            imgEnergy4 = itemView.findViewById(R.id.img_retreat_4)
            imgEnergy5 = itemView.findViewById(R.id.img_retreat_5)*/

            itemView.setOnClickListener(this)
        }

        fun preencher(card: Card) {

            card.retreatCost?.forEach {

                val viewGroup = LayoutInflater.from(context)
                    .inflate(R.layout.img_retreat, viewGroupRetreatCost, false)
                val imageView = viewGroup.findViewById<ImageView>(R.id.imageView)

                when(it){
                    RetreatCost.COLORLESS -> imageView.setImageResource(R.drawable.colorless_energy)
                    RetreatCost.WATER -> imageView.setImageResource(R.drawable.water_energy)
                    RetreatCost.FIRE -> imageView.setImageResource(R.drawable.fire_energy)
                    RetreatCost.GRASS -> imageView.setImageResource(R.drawable.grass_energy)
                    RetreatCost.FIGHTING -> imageView.setImageResource(R.drawable.fighting_energy)
                    RetreatCost.DARK -> imageView.setImageResource(R.drawable.dark_energy)
                    RetreatCost.FAIRY -> imageView.setImageResource(R.drawable.fairy_energy)
                    RetreatCost.PSYCHIC -> imageView.setImageResource(R.drawable.pyschic_energy)
                    RetreatCost.THUNDER -> imageView.setImageResource(R.drawable.thunder_energy)
                    RetreatCost.STEEL -> imageView.setImageResource(R.drawable.steel_energy)
                    RetreatCost.DRAGON -> imageView.setImageResource(R.drawable.dragon_energy)
                }
                viewGroupRetreatCost.addView(viewGroup)
            }

            // for  retreacost :  listRetreatcost
               //when(retreacost)
//                    imageView.setre
                    //viewGroupRetreatCost.addView(image)
                //
            //
            tvCard.text = card.name
            Picasso.with(context).load(card.imageUrl).into(imgCard)
            tvCardSet.text =  card.set
            tvSetNum.text = "Numero: " + card.number

            cardId = card.id!!
        }

        override fun onClick(v: View?) {
            onItemClick.invoke(cardId)
        }

    }
}