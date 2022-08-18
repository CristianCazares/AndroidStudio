package com.cristiancazares.activity1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private lateinit var inputName: EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputName = findViewById<EditText>(R.id.inputName)
        val buttonMenu = findViewById<Button>(R.id.buttonMenu)

    }

    fun switchToMenu(view: View?){
        val intent = Intent(this, MenuActivity::class.java)
        intent.putExtra("Name", inputName.text.toString())
        startActivity(intent)
    }

}