package com.portfolio.webscrapingapp

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import java.io.IOException
import java.net.URL


class Splash : AppCompatActivity(){

    private var loader: AsyncTask<Void, Void, ArrayList<String>>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        loader = LoadStuff(this)
        loader!!.execute()

    }


    internal class LoadStuff( var context: AppCompatActivity?) :
        AsyncTask<Void, Void, ArrayList<String>>() {

        var arr_spansTex: ArrayList<String>? = ArrayList()
        var dadosList: DataRunss? = null


        override fun doInBackground(vararg params: Void?): ArrayList<String> {
            try {
                val url = "http://www.corridasbr.com.br/rj/calendario.asp"
                val doc: Document =
                    Jsoup.parse(URL(url).openStream(), "ISO-8859-1", url)
                val spans: Elements = doc.select("span.tipo3")


                for (el in spans) {
                    arr_spansTex!!.add(el.text())
                }
                Log.i("data", arr_spansTex!!.toString())


            } catch (e: IOException) {
                e.printStackTrace()
            }
            return arr_spansTex!!
        }

        override fun onPostExecute(result: ArrayList<String>) {
            val c: AppCompatActivity = context!!
            //if (c != null) {
                val intent = Intent( c, MainActivity::class.java)
                intent.putExtra("RUNS", result)
                (context)!!.startActivity(intent)
                c.finish() // don't let the user come back to this screen
            //}
        }

    }

}
