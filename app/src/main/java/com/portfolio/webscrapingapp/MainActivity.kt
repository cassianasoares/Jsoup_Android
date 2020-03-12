package com.portfolio.webscrapingapp

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.String


class MainActivity : AppCompatActivity() {

    private var runsData: ArrayList<String>? = ArrayList()
    private var run: ArrayList<Run>? = ArrayList()
    private var runAdapter: RunAdapter? = null
    private var recyclerView: RecyclerView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerview)
        recyclerView!!.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView!!.setLayoutManager(linearLayoutManager)
        getData()
        runAdapter = RunAdapter(this, run!!)
        recyclerView!!.adapter = runAdapter
        runLayoutAnimation(recyclerView!!)

    }

    private fun getData(){
        runsData = intent.getStringArrayListExtra("RUNS")

        var f = 0
        for (i in 0..70) {
            run!!.add(Run(runsData!![f], runsData!![f+1], runsData!![f+2], runsData!![f+3]))
            f += 4
        }

    }


    fun runLayoutAnimation(aniRecyclerView: RecyclerView){
        val context = aniRecyclerView.context

        val layoutAnimationController : LayoutAnimationController =
            AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down)

        aniRecyclerView.layoutAnimation = layoutAnimationController
        aniRecyclerView.adapter!!.notifyDataSetChanged()
        aniRecyclerView.scheduleLayoutAnimation()
    }


}
