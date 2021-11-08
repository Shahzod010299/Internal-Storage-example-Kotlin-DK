package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    fun back(view: View) {
        Toast.makeText(this, "Back", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun load(view: View) {
        val getname = findViewById(R.id.getname) as TextView
        val getpass = findViewById(R.id.getpass) as TextView

        try {
            val fileInputStream = openFileInput("Code.txt")
            var read = -1
            val buffer = StringBuffer()
            while (fileInputStream.read() != -1) {
                buffer.append(read.toChar())
            }
            Log.d("Code", buffer.toString())
            val name = buffer.substring(0, buffer.indexOf(" "))
            val pass = buffer.substring(buffer.indexOf(" ") + 1)
            getname.text = name
            getpass.text = pass
        } catch (e: Exception) {
            e.printStackTrace()
        }
        Toast.makeText(this, "Loaded", Toast.LENGTH_SHORT).show()
    }
}