package com.example.sharedprefrences

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var tvSavedText : TextView
        var edtInput : EditText
        var btnSave : Button

        tvSavedText=findViewById(R.id.tvSavedText)
        edtInput=findViewById(R.id.edtInput)
        btnSave=findViewById(R.id.btnSave)

        var text : String

        btnSave.setOnClickListener()
        {
            text=edtInput.text.toString()

            var shared : SharedPreferences
            shared=getSharedPreferences("demo", MODE_PRIVATE)

            var editor : SharedPreferences.Editor
            editor=shared.edit()

            editor.putString("str",text).apply()
        }

        var getText : String

        var getShared : SharedPreferences
        getShared=getSharedPreferences("demo", MODE_PRIVATE)

        getText = getShared.getString("str","Saved Text Will Show Here").toString()

        tvSavedText.text=getText
    }
}