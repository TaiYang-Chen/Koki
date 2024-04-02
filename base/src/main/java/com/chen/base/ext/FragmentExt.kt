package com.chen.base.ext

import androidx.fragment.app.Fragment
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