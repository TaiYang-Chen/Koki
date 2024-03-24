package com.chen.base.ext

import java.lang.reflect.ParameterizedType

/**
 * Author: Chen
 * Email: 1563011912@qq.com
 * Create Date: 2024/3/24
 * Profile:
 */

/**
 * 获取当前类绑定的泛型clazz
 */
@Suppress("UNCHECKED_CAST")
fun <T> getGenericClazz(obj: Any, index: Int): T {
    return (obj.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[index] as T
}