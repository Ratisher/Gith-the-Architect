package com.example.gith_the_architect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import java.net.URL
import java.net.HttpURLConnection

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registration);
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val editText: EditText = findViewById(R.id.editText)
            val firstname: String = editText.text.toString()
            val editText2: EditText = findViewById(R.id.editText)
            val secondname: String = editText2.text.toString()
            val editText3: EditText = findViewById(R.id.editText)
            val telephone: String = editText3.text.toString()
            val url = URL("http://100.104.66.125:8080/api/user/")
            val connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "POST"

            if (connection.responseCode == HttpURLConnection.HTTP_OK) {
                val responseBody = connection.inputStream.bufferedReader().use { it.readText() }
                val intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
                println("Ответ: $responseBody")
            } else {
                println("Ошибка: ${connection.responseCode}")
            }
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }
}