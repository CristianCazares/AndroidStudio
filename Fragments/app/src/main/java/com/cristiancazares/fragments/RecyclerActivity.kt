package com.cristiancazares.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class RecyclerActivity : AppCompatActivity(), OnClickListener{

    private val TAG = "request"
    private lateinit var queue: RequestQueue

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

        val adapter = PuppyAdapter(data, this)

        recyclerView = findViewById(R.id.recyclerView)

        val llm = LinearLayoutManager(this)
        llm.orientation = LinearLayoutManager.VERTICAL
        val glm = GridLayoutManager(this, 2)

        recyclerView.layoutManager = llm
        recyclerView.adapter = adapter

        val jsonTest = "{'name': 'Cristian', 'age': 20}"
        val jsonTest2 = "{'name': 'Cristian', 'grades': [100, 100, 100]}"
        val jsonTest3 = "[{'name': 'Cristian', 'age': 20}, {'name': 'Jairo', 'age': 20}, {'name': 'Jaziel', 'age': 19}]"
        try{
            val obj = JSONObject(jsonTest)
            Log.wtf("JSON", obj.getString("name"))
            Log.wtf("JSON", obj.getInt("age").toString())

            val obj2 = JSONObject(jsonTest2)
            val grades = obj2.getJSONArray("grades")

            for(i in 0 until grades.length()){
                Log.wtf("JSON", grades.getString(i).toString())
            }

            val obj3 = JSONArray(jsonTest3)
            for (i in 0 until obj3.length()){
                val item = obj3.getJSONObject(i)
                Log.wtf("JSON", item.getString("name"))
                Log.wtf("JSON", item.getInt("age").toString())
            }
        }catch (e: JSONException){
            e.printStackTrace()
        }

        queue = Volley.newRequestQueue(this)

        var url = "https://www.google.com"

        var stringRequest = StringRequest(
            Request.Method.GET,
            url,
            { res ->
                Toast.makeText(
                    this,
                    "response: $res",
                    Toast.LENGTH_SHORT
                ).show()
            },
            { error ->
                Toast.makeText(
                    this,
                    "error $error",
                    Toast.LENGTH_SHORT
                ).show()
            }
        ).apply {
            tag = TAG
        }

        url = "https://bitbucket.org/itesmguillermorivas/partial2/raw/992b45809954609ff8521e14f8f70f359c68a3ea/videojuegos.json\n"

        val jsonArrayRequest = JsonArrayRequest(
            Request.Method.GET,
            url,
            null,
            { res ->
                for (i in 0 until res.length()){
                    val item = res.getJSONObject(i)
                    Log.wtf("JSONREQ", item.getString("nombre"))
                    Log.wtf("JSONREQ", item.getString("anio"))
                    Log.wtf("JSONREQ", item.getString("imagen"))
                    val plattforms = item.getJSONArray("plataformas")
                    for(j in 0 until plattforms.length()){
                        Log.wtf("JSONREQ", plattforms.getString(j))
                    }
                }
            },
            { error ->
                Toast.makeText(
                    this,
                    "error: $error",
                    Toast.LENGTH_SHORT
                ).show()
            }
        ).apply {
            tag = TAG
        }

        queue.add(jsonArrayRequest)

    }

    override fun onClick(row: View) {
        val pos = recyclerView.getChildLayoutPosition(row)
        Toast.makeText(this, data[pos], Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        queue.cancelAll(TAG)
    }
}