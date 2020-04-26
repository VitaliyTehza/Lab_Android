@file:Suppress("ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE")

package com.codegemz.kotlinx.lesson3

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.core.content.ContextCompat
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class MainView : AnkoComponent<MainActivity> {
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        verticalLayout {

            textView {
                // for multi-language support strings are stored here: res/values/string.xml
                text = resources.getString(R.string.layout_elements)
                textSize = 22f
                textColor = Color.GRAY
            }.lparams(width = wrapContent) {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = dip(30)
            }

            verticalLayout {
                gravity = Gravity.CENTER_HORIZONTAL
                leftPadding = dip(50)
                rightPadding = dip(50)

                val displayTextView = textView {
                    // you can also set the text right here
                    text = "TextView"
                    textSize = 24f
                    textColor = Color.GRAY
                }.lparams {
                    topMargin = dip(40)
                }

                val items = arrayOf("Celsius", "Fahrenheit", "Kelvin")
                @Suppress("ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE")
                lateinit var firstSpinner: Spinner
                 lateinit var secondSpinner: Spinner
                lateinit var enterEditText: EditText

                linearLayout {
                    firstSpinner = spinner {
                        adapter = ArrayAdapter(ctx, android.R.layout.simple_spinner_dropdown_item, items)
                    }.lparams(width = wrapContent) {
                        topMargin = dip(40)
                    }

                    enterEditText = editText {
                        hint = "EditText"
                    }.lparams(width = dip(150)) {
                        topMargin = dip(40)
                    }
                }

                linearLayout {
                    secondSpinner = spinner {
                        adapter = ArrayAdapter(ctx, android.R.layout.simple_spinner_dropdown_item, items)
                    }.lparams(width = wrapContent) {
                        topMargin = dip(40)
                    }

                    enterEditText = editText {
                        hint = "EditText"
                    }.lparams(width = dip(150)) {
                        topMargin = dip(40)
                    }
                }

                val applyButton = button("Apply") {
                    leftPadding = dip(50)
                    rightPadding = dip(50)

                    onClick {
                        val enteredText = enterEditText.text.toString()
                        if (enteredText.isNotBlank()) {
                            displayTextView.text = enteredText
                        }
                        toast("You pressed the button!")
                    }
                }.lparams(width = matchParent) {
                    topMargin = dip(40)
                }

                checkBox {
                    text = resources.getString(R.string.disable_button)
                    setOnClickListener {
                        val disableCheckBox = it as CheckBox
                        applyButton.isEnabled = !disableCheckBox.isChecked
                    }
                }.lparams() {
                    topMargin = dip(40)
                }
            }

            // for easy reuse colors are stored in the file: res/values/colors.xml
            val backgroundColor = ContextCompat.getColor(ctx, R.color.colorGray)
            background = ColorDrawable(backgroundColor)
        }
    }
}