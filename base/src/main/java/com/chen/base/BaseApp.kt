package com.chen.base

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

/**
 * Author: Chen
 * Email: 1563011912@qq.com
 * Create Date: 2024/3/26
 * Profile:
 */
open class BaseApp : Application() {
    override fun onCreate() {
        super.onCreate()

        initRouter()
    }

    private fun initRouter() {
        if(BuildConfig.isRelease){
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }
}