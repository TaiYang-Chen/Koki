package com.chen.koki

import com.chen.base.BaseApp
import com.tencent.mmkv.MMKV

/**
 * Author: Chen
 * Email: 1563011912@qq.com
 * Create Date: 2024/3/26
 * Profile:
 */
class App : BaseApp() {
    override fun onCreate() {
        super.onCreate()

        MMKV.initialize(this.filesDir.absolutePath+"/mmkv")
    }
}