package com.shoppi.app.repository.category

import com.google.gson.Gson
import com.shoppi.app.model.Category
import com.shoppi.app.network.ApiClient

class CategoryRemoteDataSource(private val apiClient: ApiClient): CategoryDataSource {

    private val gson = Gson()

//    override fun getHomeData(): HomeData? {
//        val homeJsonString = assetLoader.getJsonString("home.json")
//        return  gson.fromJson(homeJsonString, HomeData::class.java)
//    }
    override suspend fun getCategories(): List<Category> {
        return apiClient.getCategories()
    }
}