package com.example.ayopintar.utils

import com.google.android.material.textfield.TextInputLayout

object InputValidate {
    fun checkTextViewEmpty(textView: TextInputLayout, fieldName: String): Boolean {
        val text = textView.editText?.text.toString().trim()
        if (text.isEmpty()) {
            textView.error = "Field $fieldName tidak boleh kosong."
            textView.errorIconDrawable = null
            return false
        }
        return true
    }
}