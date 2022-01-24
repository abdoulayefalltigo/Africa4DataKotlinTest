package com.test.africafordata.ui.activities

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.android.volley.Request.Method.GET
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.test.africafordata.R
import com.test.africafordata.ui.fragments.user.UserFragment
import dagger.android.support.DaggerAppCompatActivity
import org.json.JSONException

class MainActivity : DaggerAppCompatActivity() {
    private var requestQueue: RequestQueue? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this, R.color.colorPrimaryDark)))
        requestQueue = Volley.newRequestQueue(this)
        //jsonParse("devices")
    }

    fun jsonParse(element : String) {
        val url = "http://storage42.com/modulotest/data.json"
        val request = JsonObjectRequest(GET, url, null, { response ->
            try {
                val jsonArray = response.getJSONArray(element)
                Log.d("TEST FALL", jsonArray.toString())
            } catch (e: JSONException) {
                        e.printStackTrace()
                    }
        }, { error -> error.printStackTrace() })
        requestQueue?.add(request)
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
