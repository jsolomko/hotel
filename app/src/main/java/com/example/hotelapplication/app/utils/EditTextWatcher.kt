package com.example.hotelapplication.app.utils

import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import com.google.android.material.textfield.TextInputEditText

class EditTextWatcher(
    private val phoneEdit: TextInputEditText
) : TextWatcher {
    init {
        phoneEdit.setText("123")
    }

    override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
        var currentText: String = phoneEdit.text.toString()


    }

    override fun afterTextChanged(s: Editable?) {

    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }
}
//
//val input = text.toString().replace("*", "")
//val formattedText = buildString {
//    var inputIndex = 0
//    for (i in 1 until 12) {
//        if (i < input.length + 1) {
//            append(input[inputIndex])
//            inputIndex++
//        } else {
//            append("*")
//        }
//    }
//}
//phoneEdit.removeTextChangedListener(this)
//phoneEdit.setText(formattedText)
//phoneEdit.setSelection(formattedText.length)
//phoneEdit.addTextChangedListener(this)