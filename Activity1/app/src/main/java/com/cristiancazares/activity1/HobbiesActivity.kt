package com.cristiancazares.activity1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class HobbiesActivity : AppCompatActivity() {

    lateinit var inputHobbies: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hobbies)

        inputHobbies = findViewById<EditText>(R.id.inputHobbies)
    }

    fun submitHobbies(view: View?){
        val intent = Intent()
        intent.putExtra("Hobbies", inputHobbies.text.toString())

        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}