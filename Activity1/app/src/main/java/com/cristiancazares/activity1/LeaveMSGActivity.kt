package com.cristiancazares.activity1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class LeaveMSGActivity : AppCompatActivity() {

    lateinit var inputMSG: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leave_msg)

        inputMSG = findViewById(R.id.inputMSG)
    }

    fun sendMSG(view: View?){
        val intent = Intent()
        intent.putExtra("MSG", inputMSG.text.toString())

        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}