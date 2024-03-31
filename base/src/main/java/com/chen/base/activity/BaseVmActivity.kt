package com.chen.base.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.chen.base.ext.getGenericClazz
import com.chen.base.ext.isNotNull
import com.chen.base.vm.BaseViewModel

/**
 * Author: Chen
 * Email: 1563011912@qq.com
 * Create Date: 2024/3/24
 * Profile:
 */
abstract class BaseVmActivity<VM : BaseViewModel> : AppCompatActivity() {

    lateinit var mViewModel: VM

    abstract fun createObserver()

    abstract fun layoutId(): Int

    abstract fun initView(savedInstanceState: Bundle?)

    open fun initDataBind(): View? {
        return null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDataBind().isNotNull({
            setContentView(it)
        }, {
            setContentView(layoutId())
        })
        init(savedInstanceState)
    }

    private fun init(savedInstanceState: Bundle?) {
        mViewModel = createViewModel()
        initView(savedInstanceState)
        createObserver()
    }

    private fun createViewModel(): VM {
        return ViewModelProvider(this)[getGenericClazz(this, 0)]
    }
}