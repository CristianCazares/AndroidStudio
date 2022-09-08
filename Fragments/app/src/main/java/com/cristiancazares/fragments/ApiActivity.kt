package com.cristiancazares.fragments

import android.content.Intent
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

class ApiActivity : AppCompatActivity(), OnClickListener{

    private val TAG = "request"
    private lateinit var queue: RequestQueue

    lateinit var recyclerView: RecyclerView
    lateinit var data: ArrayList<ArrayList<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api)

        queue = Volley.newRequestQueue(this)
    }

    override fun onClick(row: View) {
        val pos = recyclerView.getChildLayoutPosition(row)
        val intent = Intent(this, ApiInfoActivity::class.java)
        intent.putExtra("id", data[pos][0])
        intent.putExtra("name", data[pos][1])
        intent.putExtra("country", data[pos][3])
        intent.putExtra("role", data[pos][2])

        startActivity(intent)
    }

    override fun onStop() {
        super.onStop()
        queue.cancelAll(TAG)
    }

    fun load(view: View?) {
        data = ArrayList()
        var url = "https://raw.githubusercontent.com/CristianCazares/AndroidStudio/main/ValorantAgents.json"

        val jsonArray = JsonArrayRequest(
            Request.Method.GET,
            url,
            null,
            { res ->
                for(i in 0 until res.length()){
                    val item = res.getJSONObject(i)
                    val itemData = ArrayList<String>()
                    itemData.add(item.getString("id"))
                    itemData.add(item.getString("name"))
                    itemData.add(item.getString("role"))
                    itemData.add(item.getString("country"))

                    data.add(itemData)
                }

                val adapter = ApiAdapter(data, this)

                recyclerView = findViewById(R.id.recyclerViewApi)

                val llm = LinearLayoutManager(this)
                llm.orientation = LinearLayoutManager.VERTICAL

                recyclerView.layoutManager = llm
                recyclerView.adapter = adapter

                queue = Volley.newRequestQueue(this)

            },
            { error ->
                Log.wtf("JSONREQ", "error $error")
            }
        ).apply {
            tag = TAG
        }
        queue.add(jsonArray)
    }
}