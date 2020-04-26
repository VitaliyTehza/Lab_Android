package com.codegemz.kotlinx.lesson6

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import com.codegemz.kotlinx.lesson6.net.response.SearchItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        search_button.setOnClickListener {
            if (search_edit_text.text.toString().isNotEmpty()) {
                searchRequest(search_edit_text.text.toString())
            }
        }

        viewModel.searchResponse.observe(this, Observer {
            if (it != null) {
                searchResponse(it)
            }
        })

        addListeners()
    }

    private fun searchRequest(searchString: String) {
        viewModel.searchRequest(searchString)
        search_edit_text.hint = search_edit_text.text
        search_edit_text.text.clear()
    }

    private fun searchResponse(searchItems: List<SearchItem>) {
        val searchAdapter = SearchAdapter(searchItems)
        response_recycle_view.adapter = searchAdapter

        val linearLayoutManager = androidx.recyclerview.widget.LinearLayoutManager(this);
        response_recycle_view.setLayoutManager(linearLayoutManager);
        val dividerItemDecoration = androidx.recyclerview.widget.DividerItemDecoration(
            response_recycle_view.context,
            linearLayoutManager.getOrientation()
        )
        response_recycle_view.addItemDecoration(dividerItemDecoration)
    }

    private fun addListeners() {
        search_edit_text.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) { }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                search_button.isEnabled = !search_edit_text.text.isEmpty()
            }
        })
    }
}