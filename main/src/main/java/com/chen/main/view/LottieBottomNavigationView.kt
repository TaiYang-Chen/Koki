package com.chen.main.view

import android.content.Context
import android.util.AttributeSet
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.forEach
import androidx.navigation.NavController
import com.airbnb.lottie.LottieCompositionFactory
import com.airbnb.lottie.LottieDrawable
import com.chen.main.R
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * Author: Chen
 * Email: 1563011912@qq.com
 * Create Date: 2024/4/3
 * Profile:
 */
class LottieBottomNavigationView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0, defStyleRes: Int = 0
) : BottomNavigationView(context, attrs, defStyleAttr, defStyleRes) {

    private var mCurrentPosition = 0

    private var lottieAnimations: List<Pair<String, String>>? = null
    private var controller: NavController? = null

    fun initBottomNavigationView(controller: NavController, pairAnimationList: List<Pair<String, String>>) {
        this.lottieAnimations = pairAnimationList
        this.controller = controller
        menu.apply {
            for (i in pairAnimationList.indices) {
                add(Menu.NONE, i, Menu.NONE, pairAnimationList[i].second)
                setLottieDrawable(pairAnimationList[i].first, i)
            }
        }
        initClickEvent()

        setItemTextAppearanceInactive(R.style.HomeLottieBottom);
        setItemTextAppearanceActive(R.style.HomeLottieBottom);
    }

    private fun Menu.setLottieDrawable(jsonKey: String, position: Int) {
        findItem(position).icon = replaceLottieDrawable(jsonKey)
    }

    private fun replaceLottieDrawable(jsonKey: String): LottieDrawable {
        return LottieDrawable().apply {
            val result = LottieCompositionFactory.fromAssetSync(context.applicationContext, jsonKey)
            callback = this@LottieBottomNavigationView
            composition = result.value
        }
    }

    private fun initClickEvent() {
        // 选中
        setOnItemSelectedListener { item ->
            handleNavigationItem(item)
            true
        }
        // 再次选中
        setOnItemReselectedListener {
            OnItemReselectedListener { item ->
                handleNavigationItem(item)
            }
        }
        // 禁止长按弹出
        menu.forEach {
            val menuItemView = findViewById<BottomNavigationItemView>(it.itemId)
            menuItemView.setOnLongClickListener { true }
        }
    }

    private fun handleNavigationItem(item: MenuItem) {
        handlePlayLottieAnimation(item)
        mCurrentPosition = item.itemId
        controller?.navigate(arrayOf(R.id.homeFragment)[mCurrentPosition])
    }

    private fun handlePlayLottieAnimation(item: MenuItem) {
        // 播放动画
        (item.icon as? LottieDrawable)?.playAnimation()

        // 处理tab切换，初始lottie
        if (item.itemId != mCurrentPosition) {
            menu.findItem(mCurrentPosition)?.icon = replaceLottieDrawable(lottieAnimations!![mCurrentPosition].first)
        }
    }
}