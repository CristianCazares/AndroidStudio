package com.cristiancazares.activity2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    lateinit var db : DBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = DBHelper(this)

        db.saveGreet(1, "Hello!")
        db.saveGreet(2, "Glad to have you back")

        var greet1 = findViewById<TextView>(R.id.textGreet1)
        greet1.text = db.getGreet(1)
        var greet2 = findViewById<TextView>(R.id.textGreet2)
        greet2.text = db.getGreet(2)

    }

    fun switchToMyHobbies(view: View?){
        val intent = Intent(this, MyHobbiesActivity::class.java)
        startActivity(intent)
    }

    fun switchToMyFriends(view: View?){
        val intent = Intent(this, MyFriendsActivity::class.java)
        startActivity(intent)
    }
}