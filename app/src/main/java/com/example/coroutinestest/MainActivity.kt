package com.example.coroutinestest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var showMessage : Button
    private lateinit var startTask : Button
    private lateinit var taskCounter : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showMessage = findViewById(R.id.showMessage)
        startTask = findViewById(R.id.StartTask)
        taskCounter = findViewById(R.id.TaskCounter)

        showMessage.setOnClickListener(){

            Toast.makeText(this, "Button is Clicked", Toast.LENGTH_SHORT).show()
        }

        startTask.setOnClickListener(){
            //starts show long running task which potentially blocks the ui
            GlobalScope.launch(Dispatchers.IO) {
                for (i in 0..10000000){
                withContext(Dispatchers.Main){
                    taskCounter.text = i.toString()
                }
                } // using coroutines to solve the problem
            }

        }
    }
}