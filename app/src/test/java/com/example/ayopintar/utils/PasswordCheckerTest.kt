package com.example.ayopintar.utils

import org.junit.Assert
import org.junit.Test

class PasswordCheckerTest{
    @Test
    fun `given correct password then should password correctly`(){
        val password = "P4sswawdawdadawd0rd@"
        Assert.assertEquals(true, PasswordChecker.checkPasswordStrength(password))
    }
    @Test
    fun `given wrong format password then should password false`(){
        val password = "weakPass"
        Assert.assertEquals(false, PasswordChecker.checkPasswordStrength(password))
    }
    @Test
    fun `given password the same password then should return true`(){
        val password1 = "P4sswawdawdadawd0rd@"
        val password2 = "P4sswawdawdadawd0rd@"
        Assert.assertEquals(true, PasswordChecker.checkSimilaritiesPassword(password1, password2))
    }
    @Test
    fun `given password not same password then should return false`(){
        val password1 = "P4ssd0rd@"
        val password2 = "P4sswawdawdadawd0rd@"
        Assert.assertEquals(false, PasswordChecker.checkSimilaritiesPassword(password1, password2))
    }
}