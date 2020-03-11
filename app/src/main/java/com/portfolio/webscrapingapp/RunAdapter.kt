package com.portfolio.webscrapingapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*

class RunAdapter(private val context: Context, private val runs: ArrayList<Run>): RecyclerView.Adapter<RunAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val txt_name_run = itemView.txt_name_run
        val txt_distance = itemView.txt_distance
        val txt_date = itemView.txt_date
        val txt_city = itemView.txt_city

        fun bindView(run: Run){

            txt_name_run.text = run.name
            txt_distance.text = run.distance
            txt_date.text = run.dateEvent
            txt_city.text = run.city

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ListViewHolder(view)
    }


    override fun getItemCount(): Int {
       return runs.size
    }


    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bindView(runs[position])
    }

}