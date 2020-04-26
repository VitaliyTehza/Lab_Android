package com.codegemz.kotlinx.lesson4

import android.app.TimePickerDialog
import android.graphics.Color
import android.view.Gravity
import android.widget.Button
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import java.text.SimpleDateFormat
import java.util.*

class MainView : AnkoComponent<MainActivity> {
    private lateinit var playButton: Button

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        verticalLayout {
            playButton = button("Waiting for service..").lparams {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = dip(70)
            }

            val calendar = Calendar.getInstance()
            val timeTextView = textView {
                text = SimpleDateFormat("HH:mm").format(calendar.time)
                textSize = 24f
            }.lparams {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = dip(70)
            }

            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                calendar.set(Calendar.HOUR_OF_DAY, hour)
                calendar.set(Calendar.MINUTE, minute)
                // call function
                timeTextView.text = SimpleDateFormat("HH:mm").format(calendar.time)
            }

            timeTextView.setOnClickListener {
                TimePickerDialog(ctx, timeSetListener, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(
                    Calendar.MINUTE), true).show()
            }
        }
    }

    internal fun updatePlayButton(isPlaying: Boolean) {
        with(playButton) {
            if (isPlaying) {
                text = resources.getString(R.string.stop_music)
                setBackgroundColor(Color.CYAN)
                onClick {
                    MyService.stop(context)
                }
            } else {
                text = resources.getString(R.string.play_music)
                setBackgroundColor(Color.GREEN)
                onClick {
                    MyService.play(context)
                }
            }
        }
    }
}