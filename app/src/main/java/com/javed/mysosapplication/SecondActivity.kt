package com.javed.mysosapplication

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*


class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        btnSubmit.setOnClickListener {
            val userName = etName.text.toString()
            val contact = etContact.text.toString()
            val address = etAddress.text.toString()


            if (userName.isNotBlank() and contact.isNotBlank() and address.isNotBlank()) {
                hideKeyboard()
                clearEditText()
                val intent = Intent()
                intent.putExtra("UserName", userName)
                intent.putExtra("Contact", contact)
                intent.putExtra("Address", address)
                setResult(RESULT_OK, intent)
                onBackPressed()
            }
        }
    }

    private fun hideKeyboard() {
        val hide = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        hide.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
    }

    private fun clearEditText() {
        etName.setText("")
        etContact.setText("")
        etAddress.setText("")
    }


}