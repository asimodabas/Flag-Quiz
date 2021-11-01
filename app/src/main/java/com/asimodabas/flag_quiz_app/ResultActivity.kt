package com.asimodabas.flag_quiz_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        buttonTekrar.setOnClickListener {

            startActivity(Intent(this@ResultActivity,QuizActivity::class.java))
            finish()
        }

    }
}