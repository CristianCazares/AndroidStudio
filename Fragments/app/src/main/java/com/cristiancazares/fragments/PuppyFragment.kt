package com.cristiancazares.fragments

import android.content.Context
import android.os.Bundle
import android.telecom.Call
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.RuntimeException

private const val NAME = "name"
private const val AGE = "age"

/**
 * A simple [Fragment] subclass.
 * Use the [PuppyFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PuppyFragment : Fragment() {
    private var name: String? = null
    private var age: Int? = null

    private var listener: Callback? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

            name = it.getString(NAME)
            age = it.getInt(AGE)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_puppy, container, false)

        view.findViewById<TextView>(R.id.puppyName).apply {
            text = name
        }

        view.findViewById<TextView>(R.id.puppyAge).apply {
            text = age.toString()
        }

        view.findViewById<Button>(R.id.buttonPuppy).setOnClickListener {
            listener?.run()
        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        listener = if(context is Callback){
            context
        }else{
            throw  RuntimeException("PLEASE IMPLEMENT THE INTERFACE")
        }
    }

    interface Callback {
        fun run()
    }

    companion object {
        @JvmStatic
        fun newInstance(name: String, age: Int) : PuppyFragment {
            val puppy = PuppyFragment()
            val data = Bundle()
            data.putString(NAME, name)
            data.putInt(AGE, age)
            puppy.arguments = data
            return puppy
        }
    }
}