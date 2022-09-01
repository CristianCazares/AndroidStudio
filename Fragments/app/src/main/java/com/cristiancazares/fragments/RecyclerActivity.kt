package com.cristiancazares.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var data: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        data = ArrayList()
        data.add("Fido")
        data.add("Fifi")
        data.add("Fifas")
        data.add("Firulais")

        val adapter = PuppyAdapter(data)

        recyclerView = findViewById(R.id.recyclerView)

        val llm = LinearLayoutManager(this)
        llm.orientation = LinearLayoutManager.VERTICAL
        val glm = GridLayoutManager(this, 2)

        recyclerView.layoutManager = llm
        recyclerView.adapter = adapter



    }
}