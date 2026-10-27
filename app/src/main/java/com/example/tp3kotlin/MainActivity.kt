package com.example.tp3kotlin

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var textView = findViewById<TextView>(R.id.textView)
        var btn1 = findViewById<Button>(R.id.btnIncrementer)
        var btn2 = findViewById<Button>(R.id.btnDecrementer)
        var viewModele= ViewModelProvider(this)[SimpleViewModel::class.java]
        btn1.setOnClickListener{
            viewModele.incrementer()
        }
        btn2.setOnClickListener{
            viewModele.decrementer()
        }
        viewModele.text.observe(this) { valeur ->
            textView.text = valeur.toString()
        }
    }
}
