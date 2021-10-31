package com.asimodabas.flag_quiz_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {

    private lateinit var sorular: ArrayList<Bayraklar>
    private lateinit var yanlisSecenekler: ArrayList<Bayraklar>
    private lateinit var dogruSoru: Bayraklar
    private lateinit var tumSecenekler: HashSet<Bayraklar>
    private lateinit var vt: VeritabaniYardimcisi

    private var soruSayac = 0
    private var dogruSayac = 0
    private var yanlisSayac = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        vt = VeritabaniYardimcisi(this)

        sorular = Bayraklardao().rasgele5BayrakGetir(vt)

        soruYukle() //Bayrak yüklenemiyor
        //Bayrak yüklenemiyor
        //Bayrak yüklenemiyor
        //Bayrak yüklenemiyor
        //Bayrak yüklenemiyor
        //Bayrak yüklenemiyor


        buttonA.setOnClickListener {

        }
    }

    fun soruYukle() {

        textVieSoruSayi.text = "${soruSayac + 1}.Soru"

        dogruSoru = sorular.get(soruSayac)

        imageViewBayrak.setImageResource(resources.getIdentifier(dogruSoru.bayrak_resim, "drawable", packageName
            )
        )
    }

    fun soruSayacKontrol() {

        soruSayac++
        if (soruSayac != 5) {
            soruYukle()
        } else {
            startActivity(Intent(this@QuizActivity, ResultActivity::class.java))
            finish()

        }
    }
}