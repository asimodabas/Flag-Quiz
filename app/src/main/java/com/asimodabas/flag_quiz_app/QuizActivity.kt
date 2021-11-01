package com.asimodabas.flag_quiz_app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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

        soruYukle()

        buttonA.setOnClickListener {

            soruSayacKontrol()
        }
    }

    fun soruYukle() {

        textVieSoruSayi.text = "${soruSayac + 1}.Soru"

        dogruSoru = sorular.get(soruSayac)

        imageViewBayrak.setImageResource(
            resources.getIdentifier(
                dogruSoru.bayrak_resim, "drawable", packageName
            )
        )

        yanlisSecenekler = Bayraklardao().rasgele3YanlisSecenekGetir(vt, dogruSoru.bayrak_id)
        tumSecenekler = HashSet()
        tumSecenekler.add(dogruSoru)
        tumSecenekler.add(yanlisSecenekler.get(0))
        tumSecenekler.add(yanlisSecenekler.get(1))
        tumSecenekler.add(yanlisSecenekler.get(2))

        buttonA.text = tumSecenekler.elementAt(0).bayrak_ad
        buttonB.text = tumSecenekler.elementAt(1).bayrak_ad
        buttonC.text = tumSecenekler.elementAt(2).bayrak_ad
        buttonD.text = tumSecenekler.elementAt(3).bayrak_ad

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