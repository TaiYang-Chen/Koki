package com.chen.main.ui.fragment.home

import android.os.Bundle
import com.chen.base.fragment.BaseFragment
import com.chen.base.vm.BaseViewModel
import com.chen.main.databinding.FragmentHomeChildBinding


/**
 * Author: Chen
 * Email: 1563011912@qq.com
 * Create Date: 2024/3/26
 * Profile:
 */
class HomeChildFragment : BaseFragment<BaseViewModel, FragmentHomeChildBinding>() {
    override fun initView(savedInstanceState: Bundle?) {
        mDatabind.loading.showContent()
    }
}