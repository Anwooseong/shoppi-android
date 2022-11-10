package com.shoppi.app.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.shoppi.app.*
import com.shoppi.app.databinding.FragmentHomeBinding
import com.shoppi.app.ui.common.ViewModelFactory

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels { ViewModelFactory(requireContext()) }
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner  //필수적임
        //viewLifecycleOwner 는 lifecycle 이 변경되는 알림을 받아 현재 lifecycle 상태를 알고 있는 객체를 의미
        setToolbar()
        setTopBanners()

        val pageWidth = resources.getDimension(R.dimen.viewpager_item_width)
        val pageMargin = resources.getDimension(R.dimen.viewpage_item_margin)
        val screenWidth = resources.displayMetrics.widthPixels  //화면 가로 길이
        val offset = screenWidth - pageWidth - pageMargin

        binding.viewpagerHomeBanner.offscreenPageLimit = 3
        binding.viewpagerHomeBanner.setPageTransformer { page, position ->
            page.translationX = position * (-offset)
        }
        TabLayoutMediator(binding.viewpagerHomeBannerIndicator, binding.viewpagerHomeBanner) { tab, position ->

        }.attach()
    }

    private fun setToolbar() {
        viewModel.title.observe(viewLifecycleOwner) { title ->
            binding.title = title
        }
    }

    private fun setTopBanners() {
        binding.viewpagerHomeBanner.adapter = HomeBannerAdapter().apply {
            viewModel.topBanners.observe(viewLifecycleOwner) { banners ->
                submitList(banners)
            }
        }
    }
}