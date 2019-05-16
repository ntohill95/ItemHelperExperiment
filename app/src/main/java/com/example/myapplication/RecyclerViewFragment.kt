package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    var listOfData = ArrayList<String>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_recycler_view, container, false)

        listOfData = generateFakeData()
        if (arguments != null) {
            listOfData.removeAll(listOfData)
            listOfData = arguments!!.getStringArrayList("newDataList") ?: listOfData
        }
        recyclerView = rootView.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context!!, LinearLayoutManager.HORIZONTAL, false)
        val adapter = RecyclerViewAdapter(context!!, listOfData)
        recyclerView.adapter = adapter
        return rootView
    }

    private fun generateFakeData(): ArrayList<String> {
        listOfData.add("Red")
        listOfData.add("Blue")
        listOfData.add("Green")
        listOfData.add("Orange")
        listOfData.add("Yellow")
        listOfData.add("Purple")
        listOfData.add("Black")
        listOfData.add("Pink")
        listOfData.add("Teal")
        listOfData.add("Grey")
        listOfData.add("Navy")
        listOfData.add("Baby blue")
        listOfData.add("neon yellow")
        return listOfData
    }
}