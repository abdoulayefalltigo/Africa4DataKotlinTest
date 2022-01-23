package com.test.africafordata.screens.activities

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.test.africafordata.R
import com.test.africafordata.screens.fragments.user.UserFragment
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this, R.color.colorPrimaryDark)))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.manu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.settings -> Toast.makeText(this,"Settings Selected",Toast.LENGTH_SHORT).show()
            R.id.user -> openUserFragment()
        }
        return super.onOptionsItemSelected(item)
    }


    fun openUserFragment()  {
        val transaction = this.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.nav_host_fragment, UserFragment())
        transaction.disallowAddToBackStack()
        transaction.commit()
    }
}
