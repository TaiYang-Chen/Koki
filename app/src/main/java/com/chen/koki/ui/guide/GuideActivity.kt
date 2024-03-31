package com.chen.koki.ui.guide

import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.chen.base.activity.BaseActivity
import com.chen.base.arouter.BaseARouter.goMain
import com.chen.base.ext.fixSystemUI
import com.chen.base.ext.gone
import com.chen.base.ext.visible
import com.chen.base.vm.BaseViewModel
import com.chen.koki.R
import com.chen.koki.databinding.ActivityGuideBinding
import com.chen.koki.util.CacheUtil
import com.zhpan.bannerview.BannerViewPager
import com.zhpan.indicator.enums.IndicatorSlideMode
import com.zhpan.indicator.enums.IndicatorStyle

/**
 * Author: Chen
 * Email: 1563011912@qq.com
 * Create Date: 2024/3/26
 * Profile:
 */

@Route(path = "/app/guideActivity")
class GuideActivity : BaseActivity<BaseViewModel, ActivityGuideBinding>() {

    private lateinit var welcomeGuide: BannerViewPager<Int, WelcomeGuideViewHolder>

    private var resList = arrayOf(
        R.drawable.image_guide_1,
        R.drawable.image_guide_2,
        R.drawable.image_guide_3,
        R.drawable.image_guide_4,
    )

    override fun initView(savedInstanceState: Bundle?) {

        fixSystemUI()

        mDatabind.proxy = ProxyClick()

        welcomeGuide = findViewById(R.id.welcome_guide)
        if (CacheUtil.isFirst()) {
            mDatabind.welcomeImage.gone()
            welcomeGuide.apply {
                adapter = WelcomeGuideAdapter()

                setAutoPlay(false)
                setCanLoop(false)

                setPageTransformer(DepthPageTransformer())
                setIndicatorStyle(IndicatorStyle.ROUND_RECT)
                setIndicatorSlideMode(IndicatorSlideMode.WORM)
                setIndicatorSliderGap(80)
                setIndicatorSliderRadius(80)

                setLifecycleRegistry(lifecycle)
                registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
                        if (position == resList.size - 1) {
                            mDatabind.welcomeJoin.visible()
                        } else {
                            mDatabind.welcomeJoin.gone()
                        }
                    }
                })
                create(resList.toList())
            }

        } else {
            mDatabind.welcomeImage.visible()
            mDatabind.welcomeGuide.postDelayed({
                //跳转
                goMain()
                finish()
                //带点渐变动画
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            }, 700)
        }
    }

    inner class ProxyClick {
        fun toMain() {
            CacheUtil.setFirst(false)
            goMain()
            finish()
            //带点渐变动画
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
    }
}