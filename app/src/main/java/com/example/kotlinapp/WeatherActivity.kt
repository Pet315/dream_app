package com.example.kotlinapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import java.net.HttpURLConnection
import java.net.URL
import org.json.JSONObject
import org.json.JSONException

class WeatherActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)

        val weatherList = findViewById<ListView>(R.id.weather_list)
        val city: EditText = findViewById(R.id.city)
        val searchWeather: Button = findViewById(R.id.search_weather)

        val todos: MutableList<String> = mutableListOf()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, todos)
        weatherList.adapter = adapter

        weatherList.setOnItemClickListener { adapterView, view, i, l ->
            val text = weatherList.getItemAtPosition(i).toString()
            adapter.remove(text)

            Toast.makeText(this, "Ви видалили: $text", Toast.LENGTH_LONG).show()
        }

        searchWeather.setOnClickListener {
            val cityName = city.text.toString().trim()
            val key = "58b20997ae2f79d038c31b456cafaafd"
            val url = "https://api.openweathermap.org/data/2.5/weather?q=$cityName&appid=$key&units=metric&lang=ru"

//            val connection = URL(url).openConnection() as HttpURLConnection
//            connection.requestMethod = "GET"
//            connection.connect()
//
//            val weatherData = connection.inputStream.bufferedReader().use { it.readText() }
//
//            println(weatherData)
//
//            val description = weatherData.getJSONObject("weather").getJSONObject(0).getString("description")
//            val temperature = weatherData.getJSONObject("main").getDouble("temp")
//
//            if(description != "")
//                adapter.insert("$description, температура: $temperature", 0)

//            val weatherData = URL(url).readText()

            val jsonString = "{\"name\": \"John\", \"age\": 30}"
            val jsonObject = JSONObject(jsonString)
            val name = jsonObject.getString("name")
            val age = jsonObject.getInt("age")

            if(name != "")
                adapter.insert("$name, age: $age", 0)

        }
    }
}