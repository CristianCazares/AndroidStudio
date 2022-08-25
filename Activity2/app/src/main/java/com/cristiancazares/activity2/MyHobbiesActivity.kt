package com.cristiancazares.activity2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MyHobbiesActivity : AppCompatActivity() {

    lateinit var inputHobby: EditText
    lateinit var db : DBHelper
    lateinit var textHobby : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_hobbies)

        db = DBHelper(this)

        inputHobby = findViewById(R.id.inputHobby)
        textHobby = findViewById(R.id.textHobby)
        updateHobby()
    }

    fun saveHobby(view: View?){
        db.saveHobby(inputHobby.text.toString())
        Toast.makeText(this, "Saving data...", Toast.LENGTH_SHORT).show()
        updateHobby()
    }

    fun updateHobby(){
        if(db.getHobby() != null){
            textHobby.text = db.getHobby()
        }
    }

    fun delete(view: View?){
        db.deleteHobby(inputHobby.text.toString())
    }

    fun back(view: View?){
        finish()
    }
}