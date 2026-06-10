package com.bbv.easypermission.utils

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment

/**
 * @Description:
 * @Author: yang liv
 * @Date: 2026/1/26 17:59
 */


fun Context.toast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun Fragment.toast(msg: String) {
    Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
}

fun Activity.toast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

