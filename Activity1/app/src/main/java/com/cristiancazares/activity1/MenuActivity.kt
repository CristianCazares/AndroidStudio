package com.cristiancazares.activity1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MenuActivity : AppCompatActivity() {

    lateinit var textHobbies: TextView

    val hobbiesLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK){
            val data = result.data
            textHobbies.text = "Hobbies: " + data?.getStringExtra("Hobbies").toString()
        }
    }

    val leaveMsgLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK){
            val data = result.data
            Toast.makeText(this, data?.getStringExtra("MSG"), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val textName = findViewById<TextView>(R.id.textName)
        textName.text = "Hi, " + intent.getStringExtra("Name") + "!"

        textHobbies = findViewById<TextView>(R.id.textHobbies)

    }

    fun setHobbies(view: View?){
        val intent = Intent(this, HobbiesActivity::class.java)
        hobbiesLauncher.launch(intent)
    }

    fun switchToFriends(view: View?){
        val intent = Intent(this, FriendsActivity::class.java)
        startActivity(intent)
    }

    fun switchToLeaveAMessage(view: View?){
        val intent = Intent(this, LeaveMSGActivity::class.java)
        leaveMsgLauncher.launch(intent)
    }
}