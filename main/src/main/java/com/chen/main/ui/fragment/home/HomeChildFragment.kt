package com.chen.main.ui.fragment.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.chen.base.fragment.BaseFragment
import com.chen.base.vm.BaseViewModel
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator
import com.scwang.smartrefresh.layout.api.DefaultRefreshInitializer
import com.chen.main.databinding.FragmentHomeChildBinding
import com.chen.main.util.DynamicTimeFormat
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.footer.ClassicsFooter
import com.scwang.smartrefresh.layout.header.ClassicsHeader


/**
 * Author: Chen
 * Email: 1563011912@qq.com
 * Create Date: 2024/3/26
 * Profile:
 */
class HomeChildFragment : BaseFragment<BaseViewModel, FragmentHomeChildBinding>() {

    init {
        //启用矢量图兼容
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

        //设置全局默认配置（优先级最低，会被其他设置覆盖）
        SmartRefreshLayout.setDefaultRefreshInitializer(
            DefaultRefreshInitializer { context, layout -> //全局设置（优先级最低）
                layout.setEnableAutoLoadMore(true)
                layout.setEnableOverScrollDrag(false)
                layout.setEnableOverScrollBounce(true)
                layout.setEnableLoadMoreWhenContentNotFull(true)
                layout.setEnableScrollContentWhenRefreshed(true)
                layout.setPrimaryColorsId(android.R.color.transparent, android.R.color.black)
                layout.setFooterMaxDragRate(4.0f)
                layout.setFooterHeight(45f)
            })

        SmartRefreshLayout.setDefaultRefreshHeaderCreator(
            DefaultRefreshHeaderCreator { context, layout -> //全局设置主题颜色（优先级第二低，可以覆盖 DefaultRefreshInitializer 的配置，与下面的ClassicsHeader绑定）
                layout.setEnableHeaderTranslationContent(true)
                ClassicsHeader(context).setTimeFormat(DynamicTimeFormat("更新于 %s"))
            })
        SmartRefreshLayout.setDefaultRefreshFooterCreator(
            DefaultRefreshFooterCreator { context, layout -> ClassicsFooter(context) })
    }

    override fun initView(savedInstanceState: Bundle?) {
        mDatabind.loading.showContent()
    }
}