package com.example.felipefrazao.pokeclic.presenter.feature.listcards

import android.app.AlertDialog
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.ContextThemeWrapper
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.felipefrazao.pokeclic.R
import com.example.felipefrazao.pokeclic.domain.model.Card
import com.example.felipefrazao.pokeclic.presenter.feature.getcard.CardActivity
import com.example.felipefrazao.pokeclic.presenter.intefaces.BasePresenter
import com.example.felipefrazao.pokeclic.presenter.shared.BaseActivity
import kotlinx.android.synthetic.main.activity_list_cards.*
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
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val idBtn = item?.itemId

        if(idBtn == R.id.btn_sair){
            val builder = AlertDialog.Builder(ContextThemeWrapper(this,R.style.myDialog))
            builder.setMessage("Deseja mesmo sair ?")
                .setTitle(baseContext.resources.getString(R.string.sair))
            builder.setPositiveButton("Sim",  { dialog, whichButton ->
                finish()
            })
            builder.setNegativeButton("Cancelar", { dialog, whichButton ->
            })
            val dialog = builder.create()
            dialog.show()
            dialog.window.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.colorWhite)))
        }
    return  true
    }

    override fun getPresenter(): BasePresenter<*> = presenter

    override fun showCards(cards: List<Card>) {
        val mLayoutManager = LinearLayoutManager(baseContext)
        rv_pokes.layoutManager = mLayoutManager
        val adpter = CardsAdpter(baseContext, cards) {cardId  ->
            var intent  = Intent(this, CardActivity::class.java)
            intent.putExtra("CardId", cardId)
            startActivity(intent)
        }
        rv_pokes.adapter = adpter
    }

    override fun showLoading() {
        pgr_list_card.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        pgr_list_card.visibility = View.INVISIBLE
    }


}
