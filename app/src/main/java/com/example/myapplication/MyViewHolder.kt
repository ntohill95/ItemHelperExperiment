package com.example.myapplication

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_view_cell.view.*

class MyViewHolder(view:View):RecyclerView.ViewHolder(view) {

    var textView = view.string_text_view
    var cellLayout = view.cell_layout
}
