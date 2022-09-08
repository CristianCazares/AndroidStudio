package com.cristiancazares.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ApiAdapter(var items: ArrayList<ArrayList<String>>,
                 var listener: View.OnClickListener) :
    RecyclerView.Adapter<ApiAdapter.ApiViewHolder> () {
    class ApiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var name : TextView
        var role : TextView

        init{
            name = itemView.findViewById(R.id.textAgent)
            role = itemView.findViewById(R.id.textRole)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApiViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.valorant_agents, parent, false)

        view.setOnClickListener(listener)

        return ApiViewHolder(view)
    }

    override fun onBindViewHolder(holder: ApiViewHolder, position: Int) {
        holder.name.text = items[position][1]
        holder.role.text = items[position][2]
    }

    override fun getItemCount(): Int {
        return items.size
    }

}