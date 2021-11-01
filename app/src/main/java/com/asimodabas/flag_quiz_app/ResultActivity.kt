package com.asimodabas.flag_quiz_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val dogruSayac=intent.getIntExtra("dogruSayac",0)
        textViewSonuc.text="$dogruSayac DOĞRU ${5-dogruSayac} YANLIŞ"
        textViewYuzdeSonuc.text="%${(dogruSayac*100 )/5 }BAŞARI"

        buttonTekrar.setOnClickListener {

            startActivity(Intent(this@ResultActivity,QuizActivity::class.java))
            finish()
        }

    }
}