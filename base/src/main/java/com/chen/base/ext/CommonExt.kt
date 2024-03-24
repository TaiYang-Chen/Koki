package com.chen.base.ext

/**
 * Author: Chen
 * Email: 1563011912@qq.com
 * Create Date: 2024/3/24
 * Profile:
 */

inline fun <reified T> T?.isNotNull(notNull: (T) -> Unit, isNull: () -> Unit) {
    if (this != null) {
        notNull.invoke(this)
    } else {
        isNull.invoke()
    }
}