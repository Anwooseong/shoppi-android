package com.shoppi.app.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shoppi.app.model.Banner
import com.shoppi.app.model.Title
import com.shoppi.app.repository.home.HomeRepository

class HomeViewModel(private val homeRepository: HomeRepository): ViewModel() {

    private val _title = MutableLiveData<Title>()
    val title: LiveData<Title> = _title  //_title 에 할당이 될 때  LiveData 타입으로 변환이 돼서 할당됨

    private val _topBanners = MutableLiveData<List<Banner>>()
    val topBanners: LiveData<List<Banner>> = _topBanners

    init {
        loadHomeData()
    }

    private fun loadHomeData() {
        //TODO Data Layer - Repository 에 요청
        val homeData = homeRepository.getHomeData()
        if (homeData != null) {
            _title.value = homeData.title
            _topBanners.value = homeData.topBanners
        }
    }
}