package com.example.felipefrazao.pokeclic.presenter.feature.getcard

import android.app.AlertDialog
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.View
import com.example.felipefrazao.pokeclic.R
import com.example.felipefrazao.pokeclic.domain.model.Card
import com.example.felipefrazao.pokeclic.presenter.intefaces.BasePresenter
import com.example.felipefrazao.pokeclic.presenter.shared.BaseActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_card.*
import javax.inject.Inject

class CardActivity: BaseActivity(), GetCard.View {

    @Inject lateinit var presenter: GetCard.Presenter
    var id = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card)
        presenter.onViewAttached(this)

        var bundle = intent.extras
        id = bundle.getString("CardId")

        presenter.getCard(id)


    }

    override fun getPresenter(): BasePresenter<*> = presenter

    override fun showCard(card: Card) {
        Picasso.with(this).load(card.imageUrl).into(img_card)

        //Toast.makeText(this,card.name, Toast.LENGTH_LONG).show()

        btn_more_info.setOnClickListener {
            moreInfo(card)
        }

        img_voltar.setOnClickListener {
            finish()
        }
    }


    override fun moreInfo(card: Card) {

        val msg: String
        if (card.supertype.equals("Pokémon")) {
            msg = ("Esse Pokémon possui " + card.hp + " de HP e seu número da pokédex é "
                    + card.nationalPokedexNumber + ".")
        } else if (card.supertype.equals("Trainer")) {
            msg = card.text.get(0)
        } else {
            msg = card.name
        }
        val builder = AlertDialog.Builder(ContextThemeWrapper(this,R.style.myDialog))
        builder.setMessage(msg)
            .setTitle(card.name.replace("-EX","").replace("ex",""))
        // Cria botão ok
        builder.setPositiveButton("ok", null)
        val dialog = builder.create()
        // Mostra o Dialog
        dialog.show()
        dialog.getWindow().setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.colorWhite)))
    }



    override fun showLoading() {
        btn_more_info.visibility = View.GONE
        img_card.visibility = View.GONE
        pgr_card.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        btn_more_info.visibility = View.VISIBLE
        img_card.visibility = View.VISIBLE
        pgr_card.visibility = View.GONE
    }
}