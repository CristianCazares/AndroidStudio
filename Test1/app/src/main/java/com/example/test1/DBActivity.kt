package com.example.test1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class DBActivity : AppCompatActivity() {
    private lateinit var  id : TextView
    private lateinit var name : EditText
    private lateinit var age : EditText

    private lateinit var db : DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_db)

        id = findViewById(R.id.textID)
        name = findViewById(R.id.inputNameDB)
        age = findViewById(R.id.inputAgeDB)

        db = DBHelper(this)
    }

    fun saveData(view: View?){
        db.save(name.text.toString(), age.text.toString().toInt())
        Toast.makeText(this, "Saving data...", Toast.LENGTH_SHORT).show()
    }

    fun deleteData(view: View?){
        val rows = db.delete(name.text.toString())
        Log.wtf("MYMAIN", "DELETING")
        Toast.makeText(this, "Deleted: $rows", Toast.LENGTH_SHORT).show()
    }


    fun searchData(view: View?){
        val idFound = db.search(name.text.toString())
        id.text = idFound.toString()
    }
}