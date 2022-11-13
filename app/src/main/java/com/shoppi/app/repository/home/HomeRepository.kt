package com.shoppi.app.repository.home

import com.shoppi.app.model.HomeData

class HomeRepository(private val assetDataSource: HomeAssertDataSource) {

    fun getHomeData(): HomeData? {
        return assetDataSource.getHomeData()
    }

}