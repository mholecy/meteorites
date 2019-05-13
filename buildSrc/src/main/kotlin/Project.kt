object Project {

    const val applicationId = "sk.mholecy.meteorites"
    const val targetSdk = 28
    const val minSdk = 21
    const val versionName = "1.0"
    const val versionCode = 1
    const val TASK_GROUP = "custom"

    object Flavor {
        const val DIMENSION = "api"
        const val DEVELOP = "dev"
        const val PRODUCTION = "prod"
    }

    object BuildType {
        const val DEBUG = "debug"
        const val RELEASE = "release"
    }

    object Debug {
        const val KEY_ALIAS = "androiddebugkey"
        const val KEY_PASSWORD = "android"
        const val STORE_PASSWORD = "android"
    }
}
