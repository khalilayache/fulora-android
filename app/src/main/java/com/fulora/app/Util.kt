package com.fulora.app

import android.text.TextUtils
import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * Created by danielvilha on 19/04/21
 * https://github.com/danielvilha
 */

fun String.isValidEmail(): Boolean {
    return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String.isValidPassword(): Boolean {
    if (TextUtils.isEmpty(this)) {
        return false
    }

    val pattern: Pattern
    val passwordPattern = "^(?=.*[a-z])(?=\\S+$).{4,}$"//"^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$"
    pattern = Pattern.compile(passwordPattern)
    val matcher: Matcher = pattern.matcher(this)
    return matcher.matches()
}