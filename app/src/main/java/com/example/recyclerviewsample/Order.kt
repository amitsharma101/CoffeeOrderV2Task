package com.example.recyclerviewsample

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Order : AppCompatActivity() {
    var plusSign: Button? = null
    var minusSign: Button? = null
    var placeOrder: Button? = null
    var qty: TextView? = null
    var base: TextView? = null
    var finalMessage: TextView? = null
    var coffeeTitle: TextView? = null
    var coffee: Coffee? = null
    var imageView: ImageView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        plusSign = findViewById<View>(R.id.plus) as Button
        minusSign = findViewById<View>(R.id.minus) as Button
        placeOrder = findViewById<View>(R.id.placeOrder) as Button
        qty = findViewById<View>(R.id.quantity) as TextView
        finalMessage = findViewById<View>(R.id.finalAmt) as TextView
        base = findViewById<View>(R.id.base) as TextView
        coffeeTitle = findViewById<View>(R.id.coffeeTitle) as TextView
        imageView = findViewById<View>(R.id.imageView) as ImageView

        coffee = intent.getParcelableExtra("coffee")

        base!!.text = "Base price of the Coffee is $"+coffee!!.coffeePrice
        coffeeTitle!!.text = coffee!!.coffeeName


        try {
            imageView!!.setImageResource(R.drawable::class.java.getField(coffee!!.image).getInt(null))
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: NoSuchFieldException) {
            e.printStackTrace()
        }

        plusSign!!.setOnClickListener {
            var quantity = Integer.valueOf(qty!!.text.toString())
            quantity++
            qty!!.text = "" + quantity
        }
        minusSign!!.setOnClickListener {
            var quantity = Integer.valueOf(qty!!.text.toString())
            quantity--
            if (quantity < 1) quantity = 1
            qty!!.text = "" + quantity
        }
        placeOrder!!.setOnClickListener {
            val quantity = Integer.valueOf(qty!!.text.toString())
            val price =  Integer.valueOf(coffee!!.coffeePrice)
            val amount = quantity*price
            finalMessage!!.text = "Your order for $$amount has been placed"
            qty!!.text = "1"
        }
    }
}