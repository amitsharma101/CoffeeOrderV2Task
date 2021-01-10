package com.example.recyclerviewsample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewsample.R.drawable
import com.example.recyclerviewsample.myAdapter.MyViewHolder
import java.util.*

class myAdapter(var context: Context, var list: ArrayList<Coffee>, var onClickInterface: RecyclerViewClickListener) : RecyclerView.Adapter<MyViewHolder>() {
    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var t1: TextView
        var t2: TextView
        var imageView: ImageView

        init {
            t1 = view.findViewById<View>(R.id.t1) as TextView
            t2 = view.findViewById<View>(R.id.t2) as TextView
            imageView = view.findViewById<View>(R.id.img1) as ImageView
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): MyViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.singleview, viewGroup, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(myViewHolder: MyViewHolder, i: Int) {
        val (coffeeName, coffeePrice, coffeeImage) = list[i]
        myViewHolder.t1.text = coffeeName
        myViewHolder.t2.text = "$$coffeePrice"
        try {
            myViewHolder.imageView.setImageResource(drawable::class.java.getField(coffeeImage).getInt(null))
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: NoSuchFieldException) {
            e.printStackTrace()
        }
        myViewHolder.t1.setOnClickListener { onClickInterface.setClick(i) }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}