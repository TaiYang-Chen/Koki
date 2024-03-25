package com.chen.koki

import android.os.Bundle
import com.chen.base.activity.BaseActivity
import com.chen.base.vm.BaseViewModel
import com.chen.koki.databinding.ActivityGuideBinding

class GuideActivity : BaseActivity<BaseViewModel, ActivityGuideBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide)
    }
}