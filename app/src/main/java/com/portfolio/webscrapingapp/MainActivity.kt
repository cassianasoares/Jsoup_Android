package com.portfolio.webscrapingapp

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import java.io.IOException
import java.net.URL
import kotlin.String


class MainActivity : AppCompatActivity() {

    private var runs_data: ArrayList<String>? = ArrayList()
    private var run: ArrayList<Run>? = ArrayList()
   // private var asyncTask: DataScraping? = DataScraping()
    private var runAdapter: RunAdapter? = null
    private var recyclerView: RecyclerView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //asyncTask!!.dadosList = this
        //asyncTask!!.execute()


        recyclerView = findViewById(R.id.recyclerview)
        recyclerView!!.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView!!.setLayoutManager(linearLayoutManager)
        getData()
        runAdapter = RunAdapter(this, run!!)
        recyclerView!!.adapter = runAdapter

    }

    fun getData(){
        runs_data = intent.getStringArrayListExtra("RUNS")

        //val tamanho = runs_data!!.size - 1

        var f = 0
        for (i in 0..70) {
            run!!.add(Run(runs_data!![f], runs_data!![f+1], runs_data!![f+2], runs_data!![f+3]))
            f += 4
        }

        //Log.i("teste", run!![0].toString())

        //runAdapter = RunAdapter(this, run!!)
        //recyclerView!!.adapter = runAdapter

    }


   /* override fun getAllRuns(lista: ArrayList<String>)  {
        runs_data = lista
        //Log.i("teste1", runs_data.toString())

        var f = 0

        for (i in 0..50) {
            run!!.add(Run(lista[f], lista[f+1], lista[f+2], lista[f+3]))
            f += 4
        }

        Log.i("teste", run!![0].toString())

        runAdapter = RunAdapter(this, run!!)
        recyclerView!!.adapter = runAdapter

    }*/

}
