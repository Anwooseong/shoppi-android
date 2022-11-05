package com.shoppi.app

import android.content.Context
import android.util.Log

class AssertLoader {

    fun getJsonString(context: Context, fileName: String): String? {
        return kotlin.runCatching {
            loadAssert(context, fileName)
        }.getOrNull()
    }

    private fun loadAssert(context: Context, fileName: String): String {
        return context.assets.open(fileName).use { inputStream->
            val size = inputStream.available()
            val bytes = ByteArray(size)
            inputStream.read(bytes)
            val homeData = String(bytes)
            String(bytes)
        }
    }
}