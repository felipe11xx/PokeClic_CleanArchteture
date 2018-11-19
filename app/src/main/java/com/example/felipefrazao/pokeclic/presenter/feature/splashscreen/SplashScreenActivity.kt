package com.example.felipefrazao.pokeclic.presenter.feature.splashscreen

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity

import android.view.animation.AnimationUtils
import com.example.felipefrazao.pokeclic.R
import com.example.felipefrazao.pokeclic.presenter.feature.listcards.ListCardsActivity
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity: AppCompatActivity() {

    val SPLASH_DELAY_LENGTH = 2500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        load()
    }

    private fun load(){
        val animation = AnimationUtils.loadAnimation(this, R.anim.animation_splash)
        animation.reset()

        val typeface = Typeface.createFromAsset(assets,"fonts/Pokemon Hollow.ttf")
        tv_app_name.setTypeface(typeface)
        tv_signature.text= "By: Striker2x2"

        if(tv_app_name != null && tv_signature != null && img_pokeball != null){
            img_pokeball.clearAnimation()
            img_pokeball.startAnimation(animation)
            tv_app_name.clearAnimation()
            tv_app_name.startAnimation(animation)
            tv_signature.clearAnimation()
            tv_signature.startAnimation(animation)

        }

        val runnable =  Runnable{
            intent = Intent(this,ListCardsActivity::class.java )
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
            this.finish()
        }

        Handler().postDelayed(runnable, SPLASH_DELAY_LENGTH.toLong())

    }
}