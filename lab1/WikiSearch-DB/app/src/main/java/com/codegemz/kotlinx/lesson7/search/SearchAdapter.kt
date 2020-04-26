package com.codegemz.kotlinx.lesson7.search

import android.content.Intent
import android.net.Uri
import android.text.Html
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codegemz.kotlinx.lesson7.R
import com.codegemz.kotlinx.lesson7.net.response.SearchItem
import kotlinx.android.synthetic.main.search_item.view.*


class SearchAdapter(var searchItems: List<SearchItem>) : androidx.recyclerview.widget.RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        fun bind(item: SearchItem) {
            val ctx = itemView.context
            itemView.wiki_item_title.text = item.title
            itemView.wiki_item_pageid.text = ctx.getString(R.string.page_id, item.pageid)
            itemView.wiki_item_pageid.setOnClickListener {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/?curid=${item.pageid}"))
                ctx.startActivity(browserIntent)
            }
            itemView.wiki_item_pageid.movementMethod = LinkMovementMethod.getInstance()
            itemView.wiki_item_snippet.text = Html.fromHtml(item.snippet)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.search_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        searchItems.get(position).let { searchItem ->
            holder.bind(searchItem)
        }

    }

    override fun getItemCount() = searchItems.size
}