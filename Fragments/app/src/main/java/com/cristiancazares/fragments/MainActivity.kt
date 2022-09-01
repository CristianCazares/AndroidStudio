package com.cristiancazares.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {

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
            /*transaction.remove(currentFragment)
            transaction.add(R.id.fragmentContainerView, newFragment, TAG)*/

            transaction.replace(R.id.fragmentContainerView, newFragment, TAG)
            transaction.commit()

        }


    }

    fun greet0(view: View?){
        dataFragment.greet(this)
    }

    companion object{
        private const val TAG = "lilFragment"
    }

}