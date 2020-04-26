package com.codegemz.kotlinx.lesson0

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // main layout path: res/layout/activity_main.xml
        setContentView(R.layout.activity_main)

        // textView can be found in activity_main.xml
        textview.text = "Hello, World!" // change to your text!
    }
}
