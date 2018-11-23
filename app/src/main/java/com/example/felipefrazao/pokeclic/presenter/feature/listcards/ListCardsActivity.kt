package com.example.felipefrazao.pokeclic.presenter.feature.listcards

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.felipefrazao.pokeclic.R
import com.example.felipefrazao.pokeclic.domain.model.Card
import com.example.felipefrazao.pokeclic.presenter.feature.getcard.CardActivity
import com.example.felipefrazao.pokeclic.presenter.intefaces.BasePresenter
import com.example.felipefrazao.pokeclic.presenter.shared.BaseActivity
import kotlinx.android.synthetic.main.activity_list_cards.*
import kotlinx.android.synthetic.main.menu.*
import javax.inject.Inject

class ListCardsActivity : BaseActivity(), ListCards.View {

    @Inject
    lateinit var presenter: ListCards.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_cards)

        val bundle = intent.extras
        val setCode = bundle.getString("setCode")
        presenter.onViewAttached(this)
        presenter.getCards(setCode)

        btn_back.setOnClickListener { finish() }
    }

    override fun getPresenter(): BasePresenter<*> = presenter

    override fun showCards(cards: List<Card>) {
        val mLayoutManager = LinearLayoutManager(baseContext)
        rv_pokes.layoutManager = mLayoutManager
        val adpter = CardsAdapter(baseContext, cards) {cardId  ->
            var intent  = Intent(this, CardActivity::class.java)
            intent.putExtra("CardId", cardId)
            startActivity(intent)
        }
        rv_pokes.adapter = adpter

    }

    override fun showLoading() {
        pgr_list_card.visibility = View.VISIBLE
        val typeface = Typeface.createFromAsset(assets,"fonts/Pokemon Hollow.ttf")
        tlb_app_name.setTypeface(typeface)
    }

    override fun hideLoading() {
        pgr_list_card.visibility = View.INVISIBLE
    }


}
