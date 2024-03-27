package com.chen.base.ext

import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat

/**
 * Author: Chen
 * Email: 1563011912@qq.com
 * Create Date: 2024/3/26
 * Profile: view的扩展函数类
 */

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun ImageView.setDrawable(data: Int) {
    setImageDrawable(ContextCompat.getDrawable(context, data))
}
