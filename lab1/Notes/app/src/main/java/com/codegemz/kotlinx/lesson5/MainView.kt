package com.codegemz.kotlinx.lesson5

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.View
import androidx.core.content.ContextCompat
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class MainView : AnkoComponent<MainActivity> {
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        val notesAdapter = MyAdapter(owner, owner.getNoteItemList())

        relativeLayout {
            textView {
                // id's can be created in res/values/ids.xml
                id = R.id.noteTitle
                text = resources.getString(R.string.notes)
                textSize = 24f
                textColor = Color.GRAY
            }.lparams(width = wrapContent) {
                topMargin = dip(25)
                centerHorizontally()
            }

            checkBox(R.string.filter) {
                onClick {
                    // function call
                }
                visibility = View.VISIBLE
            }.lparams {
                topMargin = dip(25)
                rightMargin = dip (25)
                alignParentRight()
            }

            listView {
                id = R.id.noteList
                adapter = notesAdapter
            }.lparams(width = matchParent) {
                topMargin = dip(15)
                below(R.id.noteTitle)
                topOf(R.id.buttons_layout)
            }

            verticalLayout {
                id = R.id.buttons_layout
                padding = dip(5)

                val inputEditText = editText {
                    hint = resources.getString(R.string.enter_note)
                }

                linearLayout {
                    gravity = Gravity.CENTER_HORIZONTAL
                    button {
                        text = resources.getString(R.string.clear_all)
                        onClick {
                            notesAdapter.clear()
                        }
                    }.lparams(weight = 1F)
                    button {
                        text = resources.getString(R.string.save)
                        onClick {
                            val enteredText = inputEditText.text.toString()
                            if (enteredText.isNotBlank()) {
                                inputEditText.setText("")
                                val noteEntity = NoteEntity(enteredText)
                                // update view
                                notesAdapter.list.add(noteEntity)
                                notesAdapter.notifyDataSetChanged()
                                // add to storage
                                val noteItemList = owner.getNoteItemList()
                                noteItemList.add(noteEntity)
                                owner.setNotesToPrefs(noteItemList)
                            }
                        }
                    }.lparams(weight = 1F)
                }
                val backgroundColor = ContextCompat.getColor(ctx, R.color.colorGray)
                background = ColorDrawable(backgroundColor)
            }.lparams(width = matchParent) {
                topMargin = dip(20)
                alignParentBottom()
            }

            val backgroundColor = ContextCompat.getColor(ctx, R.color.colorGray)
            background = ColorDrawable(backgroundColor)
        }
    }
}