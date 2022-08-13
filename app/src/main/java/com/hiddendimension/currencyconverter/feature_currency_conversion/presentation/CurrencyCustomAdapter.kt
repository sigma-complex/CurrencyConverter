package com.hiddendimension.currencyconverter.feature_currency_conversion.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hiddendimension.currencyconverter.R
import com.hiddendimension.currencyconverter.feature_currency_conversion.domain.model.CurrencyViewModel

class CurrencyCustomAdapter(private val mList: List<CurrencyViewModel>) :
    RecyclerView.Adapter<CurrencyCustomAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.currency_layout, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemsViewModel = mList[position]

        // sets the text to the textview from our itemHolder class
        holder.textView.text = itemsViewModel.text

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textView: TextView = itemView.findViewById(R.id.textView)
    }
}