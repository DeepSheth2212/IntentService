package com

import android.app.IntentService
import android.content.Intent
import android.util.Log

class MyIntentService(name: String?) : IntentService(name) {

    //Intent Service is used to do run services in background ..It doesn't works on main/UI thread .... But it is not used when we want do multithreading
    init {
        instance = this
    }
    companion object{
        private lateinit var instance : MyIntentService
        var isRunning = false


        fun stopService(){
            Log.d("MyIntentService" , "Service is stopping!")
            isRunning = false
            instance.stopSelf()//this function stops the service from running
        }
    }

    //this method calls when we pass intent in intentService class
    override fun onHandleIntent(p0: Intent?) {
        try {
            isRunning = true
            while (isRunning){
                //that is the task executing in background
                Log.d("MyIntentService" , "Thread is running")
                Thread.sleep(1000)
            }
        }catch (e:Exception){
            Thread.currentThread().interrupt()
        }
    }
    //At the end do not forget to add service in Manifest File :)
}