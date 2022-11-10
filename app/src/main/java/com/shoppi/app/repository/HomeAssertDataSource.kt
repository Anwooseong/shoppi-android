package com.shoppi.app.repository

import com.google.gson.Gson
import com.shoppi.app.AssertLoader
import com.shoppi.app.model.HomeData

class HomeAssertDataSource(private val assetLoader: AssertLoader): HomeDataSource {

    private val gson = Gson()

    override fun getHomeData(): HomeData? {
        val homeJsonString = assetLoader.getJsonString("home.json")
        return  gson.fromJson(homeJsonString, HomeData::class.java)
    }
}