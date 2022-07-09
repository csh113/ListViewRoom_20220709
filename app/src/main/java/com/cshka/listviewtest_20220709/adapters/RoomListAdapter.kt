package com.cshka.listviewtest_20220709.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.cshka.listviewtest_20220709.R
import com.cshka.listviewtest_20220709.RoomData

class RoomListAdapter(
    val mContext : Context,
    val resId : Int,
    val mList: ArrayList<RoomData>
) : ArrayAdapter<RoomData>(mContext, resId, mList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if (tempRow == null) {
            tempRow = LayoutInflater.from(mContext).inflate(resId, null)
        }

        val row = tempRow!!

        val priceTxt = row.findViewById<TextView>(R.id.priceTxt)
        val addressTxt = row.findViewById<TextView>(R.id.addressTxt)
        val levelTxt = row.findViewById<TextView>(R.id.levelTxt)
        val descriptionTxt = row.findViewById<TextView>(R.id.descriptionTxt)

        priceTxt.text = mList[position].price.toString()
        addressTxt.text = mList[position].address
        levelTxt.text = mList[position].level.toString()
        descriptionTxt.text = mList[position].description

        return row
    }
}