package com.javed.mysosapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_third.*
import java.util.*
import kotlin.collections.ArrayList


class ThirdActivity : AppCompatActivity(), SosAdapterInterface {
    private var peopleList: ArrayList<Sos> = arrayListOf()
    private var sosAdapter: SosAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

//        peopleList?.add(Sos("akon","436367","nw"))

        val intent = intent.extras
        val jsonString = intent?.getString("list").toString()
        Log.d("DataTransfer", "third activity data is $jsonString")
        val list = Gson().fromJson(jsonString, Array<Sos>::class.java)
        list?.let { l ->
            peopleList = l.toCollection(ArrayList())
        }

        Log.d("DataTransfer", "third activity data is $list")

        if (intent != null) {
            sosAdapter = SosAdapter(peopleList, this)
            Log.d("DataTransfer", "third activity data is $peopleList")
        }
        rv.adapter = sosAdapter
    }
    
    override fun onItemClick(name: String) {}
}