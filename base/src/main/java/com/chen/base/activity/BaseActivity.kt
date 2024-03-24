package com.chen.base.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.ViewDataBinding
import com.chen.base.vm.BaseViewModel

/**
 * Author: Chen
 * Email: 1563011912@qq.com
 * Create Date: 2024/3/24
 * Profile:
 */
abstract class BaseActivity<VM : BaseViewModel, DB : ViewDataBinding> : BaseVmDbActivity<VM, DB>() {

    override fun createObserver() {}

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun initView(savedInstanceState: Bundle?) {}
}
