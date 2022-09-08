package com.cristiancazares.fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity(), PuppyFragment.Callback {

    lateinit var dataFragment: DataFragmen
    lateinit var puppyFragment: PuppyFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        dataFragment = DataFragmen()

        puppyFragment = PuppyFragment.newInstance("Max", 2)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragmentContainerView, dataFragment, TAG)
        transaction.commit()

    }

    fun swap(view: View){
        //Get the fragment that is currently being displayed
        val currentFragment = supportFragmentManager.findFragmentByTag(TAG)

        //If the current fragment is not null, set the fragments.
        if(currentFragment != null){
            var newFragment : Fragment = puppyFragment
            if (currentFragment == puppyFragment)
                newFragment = dataFragment

            val transaction = supportFragmentManager.beginTransaction()

            transaction.replace(R.id.fragmentContainerView, newFragment, TAG)
            transaction.commit()

        }
    }

    fun greet(view: View?){
        dataFragment.greet(this)
    }

    fun switchToRecycler(view: View?){
        val intent = Intent(this, RecyclerActivity::class.java)
        startActivity(intent)
    }

    fun switchToAPI(view: View?){
        val i = Intent(this, ApiActivity::class.java)
        startActivity(i)
    }

    companion object{
        private const val TAG = "lilFragment"
    }

    override fun run() {
        Toast.makeText(this, "Hello from the activity", Toast.LENGTH_SHORT).show()
    }

}