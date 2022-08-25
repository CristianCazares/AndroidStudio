package com.cristiancazares.activity2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MyFriendsActivity : AppCompatActivity() {
    lateinit var db : DBHelper
    lateinit var inputFriendName : EditText
    lateinit var inputFriendHobby : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_friends)

        db = DBHelper(this)
        inputFriendName = findViewById(R.id.inputFriendName)
        inputFriendHobby = findViewById(R.id.inputFriendHobby)
    }

    fun saveFriend(view: View?){
        db.saveFriend(inputFriendName.text.toString(), inputFriendHobby.text.toString())
        Toast.makeText(this, "Friend saved.", Toast.LENGTH_SHORT).show()
    }

    fun searchFriend(view: View?){
        val idFound = db.searchFriend(inputFriendName.text.toString())

        //Look for hobby
        var hobby = ""
        if (idFound != -1){
            hobby = db.getFriendHobby(inputFriendName.text.toString())
        }else{
            hobby = "Friend not found!"
        }

        Toast.makeText(this, hobby, Toast.LENGTH_SHORT).show()
    }

    fun deleteFriend(view: View?){
        db.deleteFriend(inputFriendName.text.toString())
        Toast.makeText(this, "Friend deleted.", Toast.LENGTH_SHORT).show()
    }




    fun back(view: View?){
        finish()
    }
}