package com.example.myapplication

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.lang.Exception

class RecyclerViewAdapter(private var context: Context, private var listOfData: ArrayList<String>) :
    RecyclerView.Adapter<MyViewHolder>() {
    private var args = Bundle()
    private var newFragment = NewRecyclerViewFragment()
    private var colourHashmap = HashMap<String, String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        colourHashmap["Red"] = "#FF0000"
        colourHashmap["Blue"] = "#0000FF"
        colourHashmap["Green"] = "#008000"
        colourHashmap["Orange"] = "#FF8C00"
        colourHashmap["Yellow"] = "#FFD700"
        colourHashmap["Purple"] = "#800080"
        colourHashmap["Black"] = "#000000"
        colourHashmap["Pink"] = "#FF1493"
        colourHashmap["Teal"] = "#008080"
        colourHashmap["Grey"] = "#808080"
        colourHashmap["Navy"] = "#000080"
        colourHashmap["Baby blue"] = "#87CEFA"
        colourHashmap["lime"] = "#00FF00"

        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_view_cell, parent, false))

    }

    override fun getItemCount(): Int {
        return listOfData.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = listOfData[position]
        try {
            val colour = colourHashmap[listOfData[position]]
            holder.cellLayout.setBackgroundColor(Color.parseColor(colour))
        }catch (e:Exception){
            print(e)
        }


        holder.cellLayout.setOnLongClickListener(object : View.OnLongClickListener {
            override fun onLongClick(p0: View?): Boolean {
                args.putStringArrayList("listOfData", listOfData)
                args.putInt("position", position)
                newFragment.arguments = args
                (context as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.recycler_view_placeholder, newFragment).commit()
                return false
            }

        })
    }
}