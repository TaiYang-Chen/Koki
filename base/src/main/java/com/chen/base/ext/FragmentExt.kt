package com.chen.base.ext

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.Navigation

/**
 * Author: Chen
 * Email: 1563011912@qq.com
 * Create Date: 2024/4/3
 * Profile:
 */
fun Fragment.findNavControllerById(fragmentId: Int): NavController {
    return Navigation.findNavController(requireView().findViewById(fragmentId))
}

fun Fragment.setupFragment(targetViewId: Int, clazz: Class<out Fragment>) {
    val fragment = clazz.newInstance()
    fragment.arguments = Bundle()
    val manager: FragmentManager = childFragmentManager
    val ft: FragmentTransaction = manager.beginTransaction()
    ft.replace(targetViewId, fragment)
    ft.commit()
}