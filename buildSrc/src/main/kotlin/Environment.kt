/**
 * Author: Chen
 * Email: 1563011912@qq.com
 * Create Date: 2024/3/23
 * Profile:
 */
object Environment {
    const val isRelease = false

    const val compileSdk = 33

    const val minSdk = 25
    const val targetSdk = 33
    const val versionCode = 1
    const val versionName = "1.0"

    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    object AppId{
        const val applicationId = "com.chen.koki"
        const val main = "com.chen.main"
    }

    object namespaces{
        const val app = "com.chen.koki"
        const val base = "com.chen.base"
        const val main = "com.chen.main"
        const val login = "com.chen.login"
    }

    const val AROUTER_MODULE_NAME = "AROUTER_MODULE_NAME"
    const val manifestDebugPath = "src/main/AndroidManifestDebug.xml"
    const val manifestReleasePath = "src/main/AndroidManifestRelease.xml"
}