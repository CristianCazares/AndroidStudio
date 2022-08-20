package com.example.test1

import android.app.Activity
import android.content.Intent
import android.media.DeniedByServerException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    lateinit var input: EditText

    val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        Toast.makeText(this, "Resultado", Toast.LENGTH_SHORT).show()

        if(it.resultCode == Activity.RESULT_OK){
            val data = it.data

            Toast.makeText(this, data?.getStringExtra("nameResult"), Toast.LENGTH_SHORT).show()

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("MYMAIN", "created")

/*
        var txtExplicit : TextView = findViewById<TextView>(R.id.textView) // explicit
        var txtImplicit = findViewById<TextView>(R.id.textView) // implicit

        val txtConst = findViewById<TextView>(R.id.textView) // constant
        var txtVar = findViewById<TextView>(R.id.textView) // constant
*/
        input = findViewById(R.id.editTextTextPersonName)
        val btn1 = findViewById<Button>(R.id.button)

        Log.wtf("MYMAIN", input.text.toString())
        btn1.text = "Enviar"

        btn1.setOnClickListener {
            (it as Button).text = "Pressed"
            Toast.makeText(this, input.text, Toast.LENGTH_LONG).show()
        }
    }



    override fun onStart() {
        super.onStart()

        Log.i("MYMAIN", "started")

    }

    override fun onPause() {
        super.onPause()

        Log.w("MYMAIN", "paused")
    }

    override fun onResume() {
        super.onResume()

        Log.i("MYMAIN", "welcome back!")
    }

    override fun onStop() {
        super.onStop()
        Log.w("MAIN", "BYE BYE")
    }


    /*fun showMessage(view: View?){
        (view as Button).text = "Pressed"

        Toast.makeText(this, "Button pressed", Toast.LENGTH_SHORT).show()


    }*/

    fun switchActivity(view: View?){
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("nombre", input.text.toString())
        startActivity(intent)
    }

    fun switchToDB(view: View?){
        val intent = Intent(this, DBActivity::class.java)
        startActivity(intent)
    }
}

