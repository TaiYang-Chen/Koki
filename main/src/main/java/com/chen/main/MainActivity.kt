package com.chen.main

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.chen.base.activity.BaseActivity
import com.chen.base.vm.BaseViewModel
import com.chen.main.databinding.ActivityMainBinding
import com.chen.base.ext.fixSystemUI

/**
 * Author: Chen
 * Email: 1563011912@qq.com
 * Create Date: 2024/3/26
 * Profile:
 */

@Route(path = "/main/mainActivity")
class MainActivity : BaseActivity<BaseViewModel, ActivityMainBinding>() {
    override fun initView(savedInstanceState: Bundle?) {
        fixSystemUI()
    }
}