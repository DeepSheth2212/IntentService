package com.example

import android.content.Intent
import android.os.IBinder
import android.util.Log


class MyService: android.app.Service() {

    val TAG  = "MyService"

    init {
        Log.d(TAG , "Service is running!...")
    }
    //method if we have multiple client to connect to your service at same time if we dont need this behavious we can simply return null
    override fun onBind(p0: Intent?): IBinder? = null


    //this funtion is used to get the intent with which service is started and also to attach data with that intent so that we can communicate with service via activity
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val dataString = intent?.getStringExtra("EXTRA_DATA")
        dataString?.let {
            Log.d(TAG,dataString)
        }

        //as we know MyService will run on main thread by default so while doing complex task it may freeze the UI of app...in order to avoid that we do that tasks in separate threads like shown below...
        Thread{
            while(true){}
        }.start()

        return START_STICKY //if the service is killed by the system ..then it will be recreated when resources are available without redelivering the intent that was passed before
    }


}