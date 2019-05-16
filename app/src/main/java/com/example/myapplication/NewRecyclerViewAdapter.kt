package com.example.myapplication

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList

class NewRecyclerViewAdapter(
    private var context: Context,
    private var listOfData: ArrayList<String>,
    private var fragmentAdapterLink: FragmentAdapterLink
) :
    RecyclerView.Adapter<NewRecyclerViewHolder>(), ItemTouchHelperAdapter {

    private var colourHashmap = HashMap<String, String>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewRecyclerViewHolder {

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
        return NewRecyclerViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.new_recycler_view_cell,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return listOfData.size
    }

    override fun onBindViewHolder(holder: NewRecyclerViewHolder, position: Int) {
        holder.numberTextView.text = (position + 1).toString()
        try {
            val colour = colourHashmap[listOfData[position]]
            holder.layout.setBackgroundColor(Color.parseColor(colour))
        }catch (e: Exception){
            print(e)
        }
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int): Boolean {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(listOfData, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(listOfData, i, i - 1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
        fragmentAdapterLink.updateList(listOfData)
        return true
    }
}

interface FragmentAdapterLink {
    fun updateList(listOfUpdatedData: ArrayList<String>)
}