package com.codegemz.kotlinx.lesson7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codegemz.kotlinx.lesson7.search.SearchActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSearch.setOnClickListener {
            val searchActivity = Intent(this, SearchActivity::class.java)
            startActivity(searchActivity)
        }
    }
}
