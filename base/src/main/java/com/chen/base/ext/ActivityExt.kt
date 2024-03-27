package com.chen.base.ext

import android.graphics.Color
import android.os.Build
import android.view.View
import androidx.appcompat.app.AppCompatActivity

/**
 * Author: Chen
 * Email: 1563011912@qq.com
 * Create Date: 2024/3/28
 * Profile:
 */
fun AppCompatActivity.fixSystemUI(){
    // 获取最顶层的View
    window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    window.statusBarColor = Color.TRANSPARENT
}