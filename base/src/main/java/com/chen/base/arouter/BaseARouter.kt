package com.chen.base.arouter

import com.alibaba.android.arouter.launcher.ARouter

/**
 * Author: Chen
 * Email: 1563011912@qq.com
 * Create Date: 2024/4/1
 * Profile:
 */
object BaseARouter {

    private const val mainMain = "/main/mainActivity"

    fun goMain(){
        ARouter.getInstance().build(mainMain).navigation();
    }
}