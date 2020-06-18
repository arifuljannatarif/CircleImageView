package com.example.mvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.common.collect.ImmutableList

class Kotlinactivity : AppCompatActivity() {
    val TAG:String="KOTLINDEBUG"

fun add(){

}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlinactivity)
        for (i in 1..10){
            println("value is $i\n")
        }

    }


}
