package com.dep.template.module

import android.app.Application

object LibTemplate {

    private var isInitialized = false

    fun init(app: Application) {
        if (isInitialized) return
        isInitialized = true
    }

    fun isInitialized(): Boolean = isInitialized
}