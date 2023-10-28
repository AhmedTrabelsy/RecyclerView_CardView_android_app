package com.example.recyclerview_cardview

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    private lateinit var governorText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        governorText = this.findViewById<TextView>(R.id.governoratText)
        governorText.text =  intent.getStringExtra("governorat")
    }
}
