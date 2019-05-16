package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NewRecyclerViewFragment : Fragment(), FragmentAdapterLink {
    private var args = Bundle()


    override fun updateList(listOfUpdatedData: ArrayList<String>) {
        updatedData = listOfUpdatedData
    }

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var reorderButton: Button
    var listOfData = ArrayList<String>()
    var updatedData = ArrayList<String>()
    private var originalFragment = RecyclerViewFragment()


    var position = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_new_recycler_view, container, false)
        newRecyclerView = rootView.findViewById(R.id.new_recycler_view)
        reorderButton = rootView.findViewById(R.id.reorder_button)

        listOfData = arguments!!.getStringArrayList("listOfData")
        updatedData = listOfData
        position = arguments!!.getInt("position")
        newRecyclerView.layoutManager = LinearLayoutManager(context!!, LinearLayoutManager.HORIZONTAL, false)

        val adapter = NewRecyclerViewAdapter(context!!, listOfData, this)

        newRecyclerView.adapter = adapter

        val callback = SimpleItemTouchHelperCallback(adapter)
        val touchHelper = ItemTouchHelper(callback)
        touchHelper.attachToRecyclerView(newRecyclerView)

        reorderButton.setOnClickListener {
            args.putStringArrayList("newDataList", updatedData)
            originalFragment.arguments = args
            fragmentManager!!.beginTransaction().replace(R.id.recycler_view_placeholder, originalFragment).commit()
        }
        return rootView
    }
}