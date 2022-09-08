package com.cristiancazares.fragments

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class PuppyAdapter( var puppies: ArrayList<String>,
                    var listener: View.OnClickListener)
    : RecyclerView.Adapter<PuppyAdapter.PuppyViewHolder>() {
    class PuppyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var text1 : TextView
        var text2 : TextView
        var button : Button

        init {
            text1 = itemView.findViewById(R.id.textRow1)
            text2 = itemView.findViewById(R.id.textRow2)
            button = itemView.findViewById(R.id.buttonRow)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PuppyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row, parent, false)

        view.setOnClickListener(listener)

        val viewHolder = PuppyViewHolder(view)
        viewHolder.button.setOnClickListener {
            Log.wtf("BTN", "Hello from a row")
        }

        return PuppyViewHolder(view)
    }

    override fun onBindViewHolder(holder: PuppyViewHolder, position: Int) {
        holder.text1.text = puppies[position]
        holder.text2.text = puppies[position]
    }


    override fun getItemCount(): Int {
        return puppies.size
    }


}