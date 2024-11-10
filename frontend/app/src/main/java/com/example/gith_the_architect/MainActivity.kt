package com.example.gith_the_architect

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.content.Intent
import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import okhttp3.*
import java.io.IOException

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login);
        val button: Button = findViewById(R.id.button)

        var backgroundThread = HandlerThread("NetworkThread")
        backgroundThread.start()
        var backgroundHandler = Handler(backgroundThread.looper)

        button.setOnClickListener() {
            Log.d("MainActivity", "Кнопка нажата")
            val editText: EditText = findViewById(R.id.editText)
            val telephone: String = editText.text.toString()

            if (!telephone.isEmpty()) {

                val client = OkHttpClient()

                val request = Request.Builder()
                    .url("http://192.168.181.71:8080/api/user/authorization/" + telephone)
                    .build()

                backgroundHandler.post {
                    try {
                        client.newCall(request).execute().use { response ->
                            if (!response.isSuccessful) {
                                runOnUiThread {
                                    Toast.makeText(
                                        this@MainActivity,
                                        "Такого пользователя не существует",
                                        Toast.LENGTH_LONG
                                    ).show()
                                }
                                throw IOException(
                                    "Запрос к серверу не был успешен:" +
                                            " ${response.code} ${response.message}"
                                )
                            } else {
                                Log.d("MainActivity", "Server: ${response.header("Server")}")
                                Log.d("MainActivity", response.body!!.string())

                                runOnUiThread {
                                    val intent = Intent(this@MainActivity, MenuActivity::class.java)
                                    startActivity(intent)
                                }
                            }
                        }
                    } catch (e: IOException) {
                        Log.e("MainActivity", "Ошибка подключения: $e")
                    }
                }
            }
            else {
                runOnUiThread {
                    Toast.makeText(
                        this@MainActivity,
                        "Введите номер телефон",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
}