package com.chen.base.fragment

import androidx.databinding.ViewDataBinding
import com.chen.base.vm.BaseViewModel

abstract class BaseFragment<VM : BaseViewModel, DB : ViewDataBinding> : BaseVmDbFragment<VM, DB>() {

    override fun createObserver() {}

    override fun initData() {}

    override fun setToolbarShowBack(): Boolean = false
}