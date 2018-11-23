package com.example.felipefrazao.pokeclic.presenter.feature.listsets

import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.felipefrazao.pokeclic.R
import com.example.felipefrazao.pokeclic.domain.model.Set
import com.example.felipefrazao.pokeclic.presenter.intefaces.BasePresenter
import com.example.felipefrazao.pokeclic.presenter.shared.BaseActivity
import kotlinx.android.synthetic.main.activity_list_sets.*
import kotlinx.android.synthetic.main.menu.*
import javax.inject.Inject

class ListSetsActivity: BaseActivity(), ListSets.View {

    @Inject
    lateinit var presenter: ListSets.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_sets)
        presenter.onViewAttached(this)
        presenter.listSets()
    }



    override fun getPresenter(): BasePresenter<*> = presenter

    override fun showSets(sets: List<Set>) {
        var mLayout = LinearLayoutManager(baseContext)
        rv_sets.layoutManager = mLayout

        var adapter = SetsAdapter(this, sets)
        rv_sets.adapter = adapter



    }

    override fun showLoading() {
        prg_sets.visibility = View.VISIBLE
        btn_back.visibility = View.GONE
        val typeface = Typeface.createFromAsset(assets,"fonts/Pokemon Hollow.ttf")
        tlb_app_name.setTypeface(typeface)
    }

    override fun hideLoading() {
        prg_sets.visibility = View.GONE
    }


}