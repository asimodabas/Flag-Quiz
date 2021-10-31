package com.asimodabas.flag_quiz_app

import android.annotation.SuppressLint

class Bayraklardao {

    @SuppressLint("Range")
    fun rasgele5BayrakGetir(vt: VeritabaniYardimcisi): ArrayList<Bayraklar> {

        val bayrakListe = ArrayList<Bayraklar>()
        val db = vt.writableDatabase
        val c = db.rawQuery("SELECT * FROM bayraklar ORDER BY RANDOM() LIMIT 5", null)

        while (c.moveToNext()) {
            val bayrak = Bayraklar(
                c.getInt(c.getColumnIndex("bayrak_id")),
                c.getString(c.getColumnIndex("bayrak_ad")),
                c.getString(c.getColumnIndex("bayrak_resim"))
            )

            bayrakListe.add(bayrak)

        }
        return bayrakListe
    }

    @SuppressLint("Range")
    fun rasgele3YanlisSecenekGetir(vt: VeritabaniYardimcisi, bayrak_id: Int): ArrayList<Bayraklar> {

        val bayrakListe = ArrayList<Bayraklar>()
        val db = vt.writableDatabase
        val c = db.rawQuery(
            "SELECT * FROM bayraklar WHERE bayrak_id !=$bayrak_id ORDER BY RANDOM() LIMIT 5",
            null
        )

        while (c.moveToNext()) {
            val bayrak = Bayraklar(
                c.getInt(c.getColumnIndex("bayrak_id")),
                c.getString(c.getColumnIndex("bayrak_ad")),
                c.getString(c.getColumnIndex("bayrak_resim"))
            )

            bayrakListe.add(bayrak)

        }
        return bayrakListe
    }


}