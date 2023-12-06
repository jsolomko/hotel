package com.example.hotelapplication.app.utils

import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.widget.EditText


interface TextWatcherNotifier {
    fun validate()
}

class ListWatcher() {
    private val observers = mutableListOf<(List<TextWatcher>) -> Unit>()
    var data = emptyList<TextWatcher>()

    fun observe(observer: (List<TextWatcher>) -> Unit) {
        observers.add(observer)
        observer.invoke(data)
    }

    fun setValue(list: List<TextWatcher>) {
        data = list
        observers.onEach {
            it.invoke(data)
        }
    }
}

typealias NotifierWatcher = () -> Unit


class EmptyTextWatcher(
    var editTextList: List<EditText>
//    private val notifier: NotifierWatcher
) : TextWatcher {


    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
        editTextList.forEach {
            if (TextUtils.isEmpty(text)) it.error = "FIELD IS EMPTY"
        }

    }

    override fun afterTextChanged(p0: Editable?) {

    }

    fun setValue(list: List<EditText>) {

    }
}

class DigitTextWatcher(
//    private val notifier: NotifierWatcher
) : TextWatcher {
    var editText: EditText? = null
    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
        if (!TextUtils.isDigitsOnly(text)) editText?.error = "FIELD IS ONLY DIGIT"

    }

    override fun afterTextChanged(p0: Editable?) {

    }

}


enum class Field {
    CITIZEN,
    CITIZEN_NUMBER,
}