package com.chen.koki.ui.guide

import android.view.View
import android.widget.ImageView
import com.chen.base.ext.setDrawable
import com.chen.koki.R
import com.zhpan.bannerview.BaseViewHolder

/**
 * Author: Chen
 * Email: 1563011912@qq.com
 * Create Date: 2024/3/26
 * Profile:
 */

class WelcomeGuideViewHolder(view: View) : BaseViewHolder<Int>(view) {
    override fun bindData(data: Int, position: Int, pageSize: Int) {
        val imageView = findView<ImageView>(R.id.guide_image)
        imageView.setDrawable(data)
    }
}