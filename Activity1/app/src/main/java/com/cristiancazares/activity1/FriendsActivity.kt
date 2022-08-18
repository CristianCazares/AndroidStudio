package com.cristiancazares.activity1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class FriendsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friends)
    }

    fun switchBack(view: View?){
        finish()
    }
}