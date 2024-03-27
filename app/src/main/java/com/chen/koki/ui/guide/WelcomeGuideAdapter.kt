package com.chen.koki.ui.guide

import android.view.View
import com.chen.koki.R
import com.zhpan.bannerview.BaseBannerAdapter

/**
 * Author: Chen
 * Email: 1563011912@qq.com
 * Create Date: 2024/3/26
 * Profile:
 */

class WelcomeGuideAdapter : BaseBannerAdapter<Int, WelcomeGuideViewHolder>() {

    override fun getLayoutId(viewType: Int): Int {
        return R.layout.banner_itemwelcome
    }

    override fun createViewHolder(itemView: View, viewType: Int): WelcomeGuideViewHolder {
        return WelcomeGuideViewHolder(itemView);
    }

    override fun onBind(
        holder: WelcomeGuideViewHolder,
        data: Int,
        position: Int,
        pageSize: Int
    ) {
        holder.bindData(data, position, pageSize);
    }
}
