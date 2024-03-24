package com.chen.base.activity

import android.view.View
import androidx.viewbinding.ViewBinding
import com.chen.base.ext.inflateBindingWithGeneric
import com.chen.base.vm.BaseViewModel

/**
 * Author: Chen
 * Email: 1563011912@qq.com
 * Create Date: 2024/3/24
 * Profile:
 */
abstract class BaseVmDbActivity<VM : BaseViewModel, DB : ViewBinding> : BaseVmActivity<VM>() {

    override fun layoutId() = 0

    lateinit var mDatabind: DB

    /**
     * 创建DataBinding
     */
    override fun initDataBind(): View? {
        mDatabind = inflateBindingWithGeneric(layoutInflater)
        return mDatabind.root
    }
}