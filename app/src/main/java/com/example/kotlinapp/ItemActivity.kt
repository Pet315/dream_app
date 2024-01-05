package com.example.kotlinapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
//import com.razorpay.Checkout
import org.json.JSONObject

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

//        Checkout.preload(applicationContext)
//        val co = Checkout()
//        co.setKeyID("")

        val title: TextView = findViewById(R.id.item_list_title_one)
        val text: TextView = findViewById(R.id.item_list_text)
        val btn: TextView = findViewById(R.id.button_buy)

        title.text = intent.getStringExtra("itemTitle")
        text.text = intent.getStringExtra("itemText")
        btn.setOnClickListener {
            payment(title.text.toString())
//            Toast.makeText(this, "Дякуємо за ваше замовлення: ${title.text}. Ми зв'яжемося з вами пізніше", Toast.LENGTH_LONG).show()
        }
    }

    private fun payment(title: String) {
        val inflater: LayoutInflater = layoutInflater
        val layout: View = inflater.inflate(
            R.layout.custom_toast_layout,
            findViewById(R.id.custom_toast_layout)
        )

        val textView = layout.findViewById<TextView>(R.id.textViewToast)
        textView.text = "Дякуємо за ваше замовлення: $title. Ми зв'яжемося з вами пізніше"

        val toast = Toast(applicationContext)
        toast.duration = Toast.LENGTH_LONG
        toast.view = layout
        toast.show()

    }

//    private fun startPayment() {
//        val activity: Activity = this
//        val co = Checkout()
//
//        try {
//            val options = JSONObject()
//            options.put("name","DreamApp")
//            options.put("description","Demoing Charges")
//            options.put("image","https://s3.amazonaws.com/rzp-mobile/images/rzp.jpg")
//            options.put("theme.color", "#38366f");
//            options.put("currency","USD");
//            options.put("order_id", "order_DBJOWzybf0sJbb");
//            options.put("amount",10000)
//
//            co.open(activity,options)
//        } catch (e: Exception){
//            Toast.makeText(activity,"Error in payment: "+ e.message,Toast.LENGTH_LONG).show()
//            e.printStackTrace()
//        }
//    }
}
