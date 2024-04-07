pluginManagement {
    repositories {

        maven { setUrl("https://maven.aliyun.com/repository/google") }
        maven { setUrl("https://maven.aliyun.com/repository/public") }
        maven { setUrl("https://maven.aliyun.com/repository/gradle-plugin") }

        maven { setUrl("https://jitpack.io") }

        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {

        maven { setUrl("https://maven.aliyun.com/repository/google") }
        maven { setUrl("https://maven.aliyun.com/repository/public") }
        maven { setUrl("https://maven.aliyun.com/repository/gradle-plugin") }

        maven { setUrl("https://jitpack.io") }

        google()
        mavenCentral()
    }
}

rootProject.name = "Koki"
include(":app")
include(":base")
include(":main")
include(":login")

include(":refresh-layout")
include("::refresh-header")
include(":refresh-footer")

include(":refresh-drawable-paint")
include(":refresh-drawable-path")

include(":refresh-layout-kernel")

include(":refresh-footer-classics")
include(":refresh-footer-ball")

include("::refresh-header-classics")
include("::refresh-header-falsify")
include("::refresh-header-radar")
include("::refresh-header-material")
include("::refresh-header-two-level")
