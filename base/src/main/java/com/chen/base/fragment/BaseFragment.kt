package com.chen.base.fragment

import androidx.databinding.ViewDataBinding
import com.chen.base.vm.BaseViewModel

/**
 * Author: Chen
 * Email: 1563011912@qq.com
 * Create Date: 2024/3/26
 * Profile:
 */
abstract class BaseFragment<VM : BaseViewModel, DB : ViewDataBinding> : BaseVmDbFragment<VM, DB>() {

    override fun createObserver() {}

    override fun initData() {}

    override fun setToolbarShowBack(): Boolean = false
}