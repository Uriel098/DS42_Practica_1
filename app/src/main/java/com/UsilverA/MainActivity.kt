package com.UsilverA

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var selectedTemp = findViewById<Spinner>(R.id.spinner)
        var temp = findViewById<EditText>(R.id.editTextNumberDecimal)
        var button = findViewById<Button>(R.id.button)
        var result = findViewById<TextView>(R.id.textView3)

        if (selectedTemp !=null){
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                resources.getStringArray(R.array.Convert_options)
            )
            selectedTemp.adapter = adapter
        }
        button.setOnClickListener{
            temp.text

        }


    }
    fun convert(){
        //todo crear las conversiones
        //tarea: traer las conversiones de temperatura
    }
}