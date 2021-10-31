package com.asimodabas.flag_quiz_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        veriTabaniKopyala()

        buttonBasla.setOnClickListener {

            startActivity(Intent(this@MainActivity, QuizActivity::class.java))
        }


    }

    fun veriTabaniKopyala() {

        val copyHelper = DatabaseCopyHelper(this)
        try {
            copyHelper.createDataBase()
            copyHelper.openDataBase()

        } catch (e: Exception) {
            e.printStackTrace()

        }

    }

}