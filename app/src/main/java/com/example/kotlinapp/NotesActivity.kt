package com.example.kotlinapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast

class NotesActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)

        val notesList = findViewById<ListView>(R.id.notes_list)
        val noteName: EditText = findViewById(R.id.note_name)
        val button: Button = findViewById(R.id.add_note)

        val todos: MutableList<String> = mutableListOf()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, todos)
        notesList.adapter = adapter

        notesList.setOnItemClickListener { adapterView, view, i, l ->
            val text = notesList.getItemAtPosition(i).toString()
            adapter.remove(text)

            Toast.makeText(this, "We've deleted: $text", Toast.LENGTH_LONG).show()
        }

        button.setOnClickListener {
            val text = noteName.text.toString().trim()
            if(text != "")
                adapter.insert(text, 0)
        }
    }
}