package com.example.recyclerviewsample

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {
    var adapterClass: myAdapter? = null
    var list = ArrayList<Coffee>()
    private var recyclerView: RecyclerView? = null
    private var mAdapter: myAdapter? = null
    private var onclickInterface: RecyclerViewClickListener? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onclickInterface = RecyclerViewClickListener { abc ->
            val intent = Intent(this@MainActivity, Order::class.java)
            intent.putExtra("coffee", list[abc])
            startActivity(intent)
        }
        list.add(Coffee("AMERICANO", "10", "americano"))
        list.add(Coffee("LATTE", "20", "latte"))
        list.add(Coffee("MOCHA", "30", "mocha"))
        list.add(Coffee("CAPPUCCINO", "40", "cappuccino"))
        list.add(Coffee("ESPRESSO", "50", "espresso"))
        recyclerView = findViewById<View>(R.id.rclview) as RecyclerView
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(applicationContext)
        recyclerView!!.layoutManager = mLayoutManager
        mAdapter = myAdapter(this, list, onclickInterface!!)
        recyclerView!!.adapter = mAdapter
    }
}