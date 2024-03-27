package com.chen.koki.ui.guide

import android.content.Intent
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.chen.base.activity.BaseActivity
import com.chen.base.ext.gone
import com.chen.base.ext.visible
import com.chen.base.vm.BaseViewModel
import com.chen.koki.R
import com.chen.koki.databinding.ActivityGuideBinding
import com.chen.koki.util.CacheUtil
import com.chen.main.MainActivity
import com.zhpan.bannerview.BannerViewPager

/**
 * Author: Chen
 * Email: 1563011912@qq.com
 * Create Date: 2024/3/26
 * Profile:
 */

class GuideActivity : BaseActivity<BaseViewModel, ActivityGuideBinding>() {

    private lateinit var welcomeGuide: BannerViewPager<Int, WelcomeGuideViewHolder>

    private var resList = arrayOf(
        R.drawable.image_guide_1,
        R.drawable.image_guide_2,
        R.drawable.image_guide_3,
        R.drawable.image_guide_4,
    )

    override fun initView(savedInstanceState: Bundle?) {
        mDatabind.proxy = ProxyClick()

        welcomeGuide = findViewById(R.id.welcome_guide)
        if (CacheUtil.isFirst()) {
            mDatabind.welcomeImage.gone()
            welcomeGuide.apply {
                adapter = WelcomeGuideAdapter()

                setAutoPlay(false)
                setCanLoop(false)

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
                finish()
                //带点渐变动画
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            }, 300)
        }
    }

    inner class ProxyClick {
        fun toMain() {
            CacheUtil.setFirst(false)
            startActivity(Intent(this@GuideActivity, MainActivity::class.java))
            finish()
            //带点渐变动画
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
    }
}