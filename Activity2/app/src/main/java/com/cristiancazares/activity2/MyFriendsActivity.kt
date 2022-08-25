package com.cristiancazares.activity2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MyFriendsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_friends)
    }



    fun back(view: View?){
        finish()
    }
}