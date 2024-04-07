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
        const val refresh_layout_kernel = "com.scwang.smart.refresh.layout.kernel"
        const val refresh_layout = "com.scwang.smart.refresh.layout"
        const val refresh_footer = "com.scwang.smart.refresh.footer"
        const val refresh_footer_ball = "com.scwang.smart.refresh.footer.ball"
        const val refresh_footer_classics = "com.scwang.smart.refresh.footer.classics"
        const val refresh_drawable_paint = "com.scwang.smart.refresh.drawable.paint"
        const val refresh_drawable_path = "com.scwang.smart.refresh.drawable.path"
        const val refresh_header = "com.scwang.smart.refresh.header"
        const val refresh_header_classics = "com.scwang.smart.refresh.header.classics"
        const val refresh_header_falsify = "com.scwang.smart.refresh.header.falsify"
        const val refresh_header_radar = "com.scwang.smart.refresh.header.radar"
        const val refresh_header_material = "com.scwang.smart.refresh.header.material"
        const val refresh_header_two_level = "com.scwang.smart.refresh.header.two.level"
    }

    const val AROUTER_MODULE_NAME = "AROUTER_MODULE_NAME"
    const val manifestDebugPath = "src/main/AndroidManifestDebug.xml"
    const val manifestReleasePath = "src/main/AndroidManifestRelease.xml"
}