package com.cshka.listviewroom_20220709.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.cshka.listviewroom_20220709.R
import com.cshka.listviewroom_20220709.RoomData
import java.text.DecimalFormat

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

        var priceTxt = row.findViewById<TextView>(R.id.priceTxt)
        val addressTxt = row.findViewById<TextView>(R.id.addressTxt)
        var levelTxt = row.findViewById<TextView>(R.id.levelTxt)
        val descriptionTxt = row.findViewById<TextView>(R.id.descriptionTxt)

//        도전과제
//        1) 가격 : 세자리마다 컴마
//
//        1억 이상 : 1억 8,500으로 가공
//        1억 미만 : 8,500으로 가공
//        2) 가운데 문구 : 주소, ?층 형태로 가공
//
//        양수 (1,2,3,...) => 1층, 2층, 3층
//        0 => 반지하
//        음수 => 지하 1층, 지하 2층

        var dec = DecimalFormat("#,###")

        var priceVal : Int = mList[position].price
        var pricePrevVal : Int
        var priceRemVal : Int

//        가격 표시
        if ( priceVal < 10000 ) {
            priceTxt.text = dec.format(priceVal)
        } else {
//            28000 / 10000 = 2억 + priceTxt.text = dec.format(priceVal)
            pricePrevVal = priceVal / 10000
            priceRemVal = priceVal % 10000

            priceTxt.text = "${pricePrevVal} 억 ${dec.format(priceRemVal)}"
        }

//        RoomData의 getFormattedPrice 함수 활용 가격 표시
//            priceTxt.text = mList[position].getFormattedPrice()
            addressTxt.text = mList[position].address

//        층수 표시
        var level : Int = mList[position].level
        var levelVal : String

        if( level > 0 ) {
            levelVal = ", ${level.toString()} 층"
        }
        else if (level == 0 ) {
            levelVal = ", 반지하"
        }
        else if ( level < 0 ) {
            level = level * -1
            levelVal = ", 지하 ${level.toString()} 층"
        }
        else {  levelVal = ", 알 수 없는 층"
        }


        val TAG:String = "MainActivity : "

        Log.d(TAG, "메시지 : " + levelVal)

//        levelTxt.text = levelVal
        levelTxt.text = mList[position].getFormttedLevel()
        descriptionTxt.text = mList[position].description

        return row
    }
}