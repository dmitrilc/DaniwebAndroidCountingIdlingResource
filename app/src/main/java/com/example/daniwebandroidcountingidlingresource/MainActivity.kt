package com.example.daniwebandroidcountingidlingresource

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView_helloWorld)

        val httpClient = HttpClient()

        textView.setOnClickListener {
            //Don't pass a View to a Service in a real app!
            httpClient.doLongAsync(it as TextView)
        }
    }
}