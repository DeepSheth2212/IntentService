package com.example.intentservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.MyIntentService
import com.example.MyService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //for intent service

//        start.setOnClickListener {
//            val intent  = Intent(this,MyIntentService::class.java)
//            startService(intent) // to start service
//            textView.setText("Service Running!!!")
//        }
//
//
//        stop.setOnClickListener {
//            MyIntentService.stopService()
//            textView.setText("Service Stopped!!")
//        }


        //for Service
        start.setOnClickListener {
            Intent(this,MyService::class.java).also{
                startService(it)
                textView.text = "Service Running!"
            }
        }

        stop.setOnClickListener {
            Intent(this,MyService::class.java).also{
                stopService(it)
                textView.text = "Service Stopped!"
            }
        }

        send.setOnClickListener {
            Intent(this,MyService::class.java).also{
                val dataString = editText.text.toString()
                it.putExtra("EXTRA_DATA" , dataString)
                startService(it)

            }
        }
    }
}