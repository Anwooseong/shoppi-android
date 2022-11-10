package com.shoppi.app

import android.content.Context

class AssertLoader(private val context: Context) {

    fun getJsonString(fileName: String): String? {
        return kotlin.runCatching {
            loadAssert(fileName)
        }.getOrNull()
    }

    private fun loadAssert(fileName: String): String {
        return context.assets.open(fileName).use { inputStream->
            val size = inputStream.available()
            val bytes = ByteArray(size)
            inputStream.read(bytes)
            val homeData = String(bytes)
            String(bytes)
        }
    }
}