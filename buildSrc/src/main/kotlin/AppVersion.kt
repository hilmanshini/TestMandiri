import org.gradle.api.JavaVersion
import org.gradle.api.invocation.Gradle
import java.util.Calendar
import java.util.Locale

object AppVersion {

    private const val MAJOR = 0
    private const val MINOR = 0
    private const val PATCH = 1

    val versionName: String
        get() = "$MAJOR.$MINOR.$PATCH"

    val buildVersionCode: Int
        get() {
            val calendar: Calendar = Calendar.getInstance(Locale.ENGLISH)
            val month = (calendar.get(Calendar.MONTH) + 1) * 1_000_000
            val day = calendar.get(Calendar.DAY_OF_MONTH) * 10_000
            val hour = calendar.get(Calendar.HOUR_OF_DAY) * 100
            val minute = calendar.get(Calendar.MINUTE)
            return month + day + hour + minute
        }

    fun releaseVersionCode(sdkVersion: Int): Int {
        val estimate = 2_000_000_000
        val sdk = sdkVersion * 1_000_000
        val major = MAJOR * 10_000
        val minor = MINOR * 100
        return estimate + sdk + major + minor + PATCH
    }
}


object App {
    const val namespace = "test.mandiri"
    const val minSdk = 26
    const val targetSdk = 33
    const val compileSdk = 33

    fun appVersionCode(gradle: Gradle): Int {
        val isRelease = gradle.startParameter.taskRequests.toString()
            .contains("release", true)
        println("Check build type for version code isRelease = $isRelease")
        val versionCode = if (isRelease) AppVersion.releaseVersionCode(minSdk)
        else AppVersion.buildVersionCode
        println("Generated version code $versionCode")
        return versionCode
    }

    val versionName: String
        get() = AppVersion.versionName
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    val javaVersion = JavaVersion.VERSION_11
    const val jvmTarget = "11"
}


fun namespace(module: String) = "${App.namespace}.$module"