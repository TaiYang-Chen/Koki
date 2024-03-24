/**
 * Author: Chen
 * Email: 1563011912@qq.com
 * Create Date: 2024/3/23
 * Profile:
 */
object Environment {
    val isRelease = false

    val compileSdk = 33

    val minSdk = 25
    val targetSdk = 33
    val versionCode = 1
    val versionName = "1.0"

    val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    object AppId{
        val applicationId = "com.chen.koki"
    }

    object namespaces{
        val app = "com.chen.koki"
        val base = "com.chen.base"
    }
}