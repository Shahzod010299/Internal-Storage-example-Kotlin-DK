package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun save(view: View) {
        val editname = findViewById<View>(R.id.editName) as EditText
        val editpass = findViewById<View>(R.id.editPass) as EditText

        var file: File? = null
        var name: String = editname.getText().toString()
        val password: String = editpass.getText().toString()

        var fileOutputStream: FileOutputStream? = null
        try {
            name = "$name "
            file = filesDir
            fileOutputStream = openFileOutput("Code.txt", MODE_APPEND)
            fileOutputStream.write(name.plus("\n").toByteArray())
            fileOutputStream.write(password.plus("\n").toByteArray())
            Toast.makeText(this, "Saved \nPath --$file\tCode.txt", Toast.LENGTH_SHORT).show()
            editname.setText("")
            editpass.setText("")
            return
        } catch (ex: Exception) {
            ex.printStackTrace()
        } finally {
            try {
                fileOutputStream!!.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
    fun next(view: View) {
        Toast.makeText(this, "NEXT", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
    }
}