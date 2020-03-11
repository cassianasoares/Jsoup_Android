package com.portfolio.webscrapingapp

import android.app.Activity
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import java.io.IOException
import java.net.URL



 class DataScraping :
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

                dadosList!!.getAllRuns(lista = result)

            }
        }
