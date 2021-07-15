package com.javed.mysosapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), SosAdapterInterface {

    private val rCode = 1001
    var userName: String? = null
    var contact: String? = null
    var address: String? = null
    private val list: ArrayList<Sos>? = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMayday.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivityForResult(intent, rCode);
        }

        btnRescue.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            if (userName != null) {
                list?.add(Sos(userName.toString(), contact.toString(), address.toString()))
                var gsonlist = Gson().toJson(list)
                intent.putExtra("list", gsonlist)
//                intent.putExtra("name", userName)
//                intent.putExtra("contact", contact)
//                intent.putExtra("address", address)
                Log.d("DataTransfer", "main activity data is $gsonlist")
            }
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == rCode) {
            if (resultCode == RESULT_OK) {
                userName = data?.getStringExtra("UserName").toString()
                contact = data?.getStringExtra("Contact").toString()
                address = data?.getStringExtra("Address").toString()
                Log.d(
                    "DataTransfer",
                    "from second activity activity data is $userName $contact $address"
                )
            }
        }

    }

    override fun onItemClick(name: String) {}
}