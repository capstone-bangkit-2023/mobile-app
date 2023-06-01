package com.example.ayopintar.utils

import com.google.android.material.textfield.TextInputLayout

object InputValidate {
    /*fun checkTextViewEmpty(textView: TextInputLayout, fieldName: String): Boolean {
        val text = textView.editText?.text.toString().trim()
        if (text.isEmpty()) {
            textView.error = "Field $fieldName tidak boleh kosong."
            textView.errorIconDrawable = null
            return false
        }
        return true
    }*/

    fun checkEmpty(textInputLayout: TextInputLayout, fieldName: String) {
        val text = textInputLayout.editText?.text.toString().trim()
        if (text.isEmpty()) {
            textInputLayout.error = "Field $fieldName tidak boleh kosong."
        } else {
            textInputLayout.error = null
        }
    }

    fun checkTextViewsEmpty(textInputLayouts: List<Pair<TextInputLayout, String>>): Boolean {
        var allFieldsNotEmpty = true

        for ((textInputLayout, fieldName) in textInputLayouts) {
            val text = textInputLayout.editText?.text.toString().trim()
            if (text.isEmpty()) {
                textInputLayout.error = "Field $fieldName tidak boleh kosong."
                allFieldsNotEmpty = false
            } else {
                textInputLayout.error = null
            }
        }
        return allFieldsNotEmpty
    }
}