package com.UsilverA

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {
    private var conversion: Int = 0
    private var result: Double = 0.0
    private var value: String = ""
    private  lateinit var Total : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var selectedTemp = findViewById<Spinner>(R.id.spinner)
        var temp = findViewById<EditText>(R.id.editTextNumberDecimal)
        var button = findViewById<Button>(R.id.button)
        Total = findViewById(R.id.textView3)

        if (selectedTemp !=null){
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                resources.getStringArray(R.array.Convert_options)
            )
            selectedTemp.adapter = adapter
            selectedTemp.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    di: Long)
                {
                    Toast.makeText(this@MainActivity,
                        "opcion seleccionada:" + position, Toast.LENGTH_SHORT)
                    conversion = position
                }

                override fun onNothingSelected(parent: AdapterView<*>?){
                }

            }

        }
        button.setOnClickListener{
            value = temp.text.toString()
            convert(conversion)

        }


    }
    fun convert(_conversion: Int) {
        when (_conversion){
            0 ->{
            // F = ( C * 9/5)
                result = (value.toDouble() * 9/5 ) + 32

                Total.text = result.toString()
            }
            1 ->{
            // K = C + 273.15
                result = (value.toDouble() + 273.15)

                Total.text = result.toString()
            }
            2 ->{
            // C = ( F - 32) * 5/9
                result = (value.toDouble() - 32) * 5/9

                Total.text = result.toString()
            }
            3 ->{
            // K = (F + 459.67) / 1.8
            // (f - 32) * 5/9 +273.15
                result = (value.toDouble() - 32) * 5/9 + 273.15

                Total.text = result.toString()
            }
            4 ->{
            // C = k - 273.15
                result = (value.toDouble() - 273.15)

                Total.text = result.toString()
            }
            5 ->{
            //  F = (K - 273.15) * 1.8 + 32
                result = (value.toDouble() - 273.15) * 1.8 + 32
            }
        }
        //todo crear las conversiones
        //tarea: traer las conversiones de temperatura
    }
}