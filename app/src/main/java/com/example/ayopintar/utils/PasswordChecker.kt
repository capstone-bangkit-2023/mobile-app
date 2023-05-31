package com.example.ayopintar.utils

object PasswordChecker {
    fun checkPasswordStrength(password: String): Boolean {
        val minLength = 8
        val hasLetter = password.matches(".*[a-zA-Z]+.*".toRegex())
        val hasDigit = password.matches(".*\\d+.*".toRegex())
        val hasSpecialChar = password.matches(".*[!@#\$%^&*()_+\\-={};':\"\\\\|,.<>/?]+.*".toRegex())
        return password.length >= minLength && hasLetter && hasDigit && hasSpecialChar
    }
    fun checkSimilaritiesPassword(password1: String, password2: String): Boolean{
        return password1 == password2
    }
}