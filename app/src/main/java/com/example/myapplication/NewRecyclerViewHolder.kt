package com.example.myapplication

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.new_recycler_view_cell.view.*

class NewRecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view){

    var numberTextView = view.number_text_view
    var layout = view.new_cell_layout
}