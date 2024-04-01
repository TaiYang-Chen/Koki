package com.chen.base.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.chen.base.ext.getGenericClazz
import com.chen.base.vm.BaseViewModel

/**
 * Author: Chen
 * Email: 1563011912@qq.com
 * Create Date: 2024/3/26
 * Profile:
 */
abstract class BaseVmFragment<VM : BaseViewModel> : Fragment() {

    lateinit var viewModel: VM

    protected lateinit var activity: AppCompatActivity

    abstract fun setLayout(): Int

    abstract fun setToolbarShowBack(): Boolean

    abstract fun initView(savedInstanceState: Bundle?)

    abstract fun createObserver()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(setLayout(), container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = context as AppCompatActivity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = createViewModel()

        initView(savedInstanceState)
        createObserver()
        initData()
    }

    open fun createViewModel(): VM {
        return ViewModelProvider(this).get(getGenericClazz(this, 0))
    }

    open fun initData() {}
}