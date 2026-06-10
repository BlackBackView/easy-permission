package com.bbv.easypermission.utils

import java.text.SimpleDateFormat
import java.util.*

object EasyStringUtils {

    fun isEmpty(str: String?): Boolean {
        return str == null || str.trim().isEmpty()
    }

    fun isNotEmpty(str: String?): Boolean {
        return !isEmpty(str)
    }

    fun formatTimestamp(timestamp: Long, pattern: String = "yyyy-MM-dd HH:mm:ss"): String {
        return try {
            val sdf = SimpleDateFormat(pattern, Locale.getDefault())
            sdf.format(Date(timestamp))
        } catch (e: Exception) {
            ""
        }
    }

    fun truncateWithEllipsis(text: String, maxLength: Int): String {
        return if (text.length > maxLength) {
            text.substring(0, maxLength) + "..."
        } else {
            text
        }
    }

    fun toCamelCase(text: String): String {
        return text.split("_", "-", " ")
            .mapIndexed { index, word ->
                if (index == 0) {
                    word.lowercase()
                } else {
                    word.replaceFirstChar { it.uppercase() }
                }
            }
            .joinToString("")
    }

    fun isNumeric(str: String): Boolean {
        return str.matches(Regex("\\d+"))
    }

    fun isEmail(email: String): Boolean {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"
        return email.matches(Regex(emailRegex))
    }

    fun isPhoneNumber(phone: String): Boolean {
        return phone.matches(Regex("^1[3-9]\\d{9}$"))
    }
}