package com.example.test1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class SecondActivity : AppCompatActivity() {

    lateinit var input: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Toast.makeText(this, intent.getStringExtra("nombre"), Toast.LENGTH_SHORT).show()

        input = findViewById(R.id.inputName2)
    }

    fun backActivity(view: View?){

        val intent = Intent()
        intent.putExtra("nameResult", input.text.toString())

        setResult(Activity.RESULT_OK, intent)

        finish()
    }
}