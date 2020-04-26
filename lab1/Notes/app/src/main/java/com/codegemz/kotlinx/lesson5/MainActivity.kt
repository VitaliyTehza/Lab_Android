package com.codegemz.kotlinx.lesson5

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.list
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class MainActivity : AppCompatActivity() {
    private val sharedPrefs by lazy {
        getSharedPreferences("main", Context.MODE_PRIVATE)
    }
    private val json by lazy {
        Json(JsonConfiguration.Stable)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainView().setContentView(this)
    }

    // save noteItemList to shared preferences
    internal fun setNotesToPrefs(noteItemList : MutableList<NoteEntity>) {
        val noteString = json.stringify(NoteEntity.serializer().list, noteItemList)
        with (sharedPrefs.edit()) {
            putString("notes", noteString)
            apply()
        }
    }

    // read from shared preferences
    private fun getNoteStringFromPrefs() : String {
        return sharedPrefs.getString("notes", "[]").orEmpty()
    }

    // get the list of notes from serialized pref string
    internal fun getNoteItemList() : MutableList<NoteEntity> {
        val noteString = getNoteStringFromPrefs()
        return json.parse(NoteEntity.serializer().list, noteString).toMutableList()
    }
}
