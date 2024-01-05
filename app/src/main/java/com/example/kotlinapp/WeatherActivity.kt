package com.example.kotlinapp

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import java.net.HttpURLConnection
import java.net.URL
import org.json.JSONObject
import org.json.JSONException
import java.io.IOException
import okhttp3.OkHttpClient
import okhttp3.Request
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import okhttp3.Call
import okhttp3.Callback
import okhttp3.FormBody
import okhttp3.Response

class WeatherActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        val weatherList = findViewById<ListView>(R.id.weather_list)
        val city: EditText = findViewById(R.id.city)
        val searchWeather: Button = findViewById(R.id.search_weather)

        val todos: MutableList<String> = mutableListOf()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, todos)
        weatherList.adapter = adapter

        weatherList.setOnItemClickListener { adapterView, view, i, l ->
            val text = weatherList.getItemAtPosition(i).toString()

//            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(text))
//            startActivity(intent)

            adapter.remove(text)
            Toast.makeText(this, "Ви видалили: $text", Toast.LENGTH_LONG).show()
        }

        searchWeather.setOnClickListener {
            val cityName = city.text.toString().trim()
            val key = "58b20997ae2f79d038c31b456cafaafd"
            val url = "https://api.openweathermap.org/data/2.5/weather?q=$cityName&appid=$key&units=metric&lang=uk"

            // drafts

            val fetchData = OkHttpClient()

            val request = Request.Builder()
                .url(url)
                .build()



            fetchData.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    e.printStackTrace()
                }

                override fun onResponse(call: Call, response: Response) {
                    response.use {
                        val body = response.body?.string()
                        val jsonObject = JSONObject(body.toString())

                        val weatherArray = jsonObject.getJSONArray("weather")
                        val firstWeatherObject = weatherArray.getJSONObject(0)
                        val desc = firstWeatherObject.getString("description")

                        val temp = jsonObject.getJSONObject("main").getString("temp").toString()


                        runOnUiThread {
                            if(cityName != "")
                                adapter.insert("Опис: $desc, температура: $temp", 0)
                        }
                    }
                }
            })

        }
    }
}