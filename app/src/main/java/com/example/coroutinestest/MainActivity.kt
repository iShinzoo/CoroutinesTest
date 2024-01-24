package com.example.coroutinestest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var showMessage : Button
    private lateinit var startTask : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showMessage = findViewById(R.id.showMessage)
        startTask = findViewById(R.id.StartTask)

        showMessage.setOnClickListener(){

            Toast.makeText(this, "Button is Clicked", Toast.LENGTH_SHORT).show()
        }

        startTask.setOnClickListener(){
            //starts show long running task which potentially blocks the ui
            for (i in 0..10000000){
                Log.i("okay",i.toString())
            }
        }
    }
}