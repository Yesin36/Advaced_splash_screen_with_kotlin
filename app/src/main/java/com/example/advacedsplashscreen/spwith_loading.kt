package com.example.advacedsplashscreen

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.concurrent.thread

class spwith_loading : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_spwith_loading)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

       fun  startHeavyTask (){
           LongOperation().execute()

       }
    }





    private inner class LongOperation : AsyncTask<Void, Void, String>() {
        override fun doInBackground(vararg params: Void?): String? {
            for (i in 0..6) {
                try {
                    Thread.sleep(1000)
                } catch (e: Exception) {
                    Thread.currentThread().interrupt()
                }
            }
            return "result"
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            val intent = Intent(this@spwith_loading, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}