package com.example.sliider

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity;
import kotlinx.android.synthetic.main.content_dashboard.*

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        restartButton.setOnClickListener {
            Toast.makeText(this, "Kill the application manually please :)", Toast.LENGTH_SHORT).show()
        }
    }
}
