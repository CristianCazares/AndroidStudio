package com.cristiancazares.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlin.math.log

class ApiInfoActivity : AppCompatActivity() {

    private lateinit var id : TextView
    private lateinit var name : TextView
    private lateinit var country : TextView
    private lateinit var role : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api_info)

        id = findViewById(R.id.textAgentID)
        name = findViewById(R.id.textAgentName)
        country = findViewById(R.id.textAgentCountry)
        role = findViewById(R.id.textAgentRole)

        id.text = "Agent ${intent.getStringExtra("id")}"
        name.text = intent.getStringExtra("name")
        country.text = intent.getStringExtra("country")
        role.text = "Role: ${intent.getStringExtra("role")}"
    }
}