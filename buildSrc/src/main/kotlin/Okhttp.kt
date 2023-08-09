import implementation
import org.gradle.api.artifacts.dsl.DependencyHandler
import testImplementation

fun DependencyHandler.okhttp() {
    val version = "4.10.0"
    implementation(
        "com.squareup.okhttp3:okhttp:$version", "com.squareup.okhttp3:logging-interceptor:$version"
    )
    testImplementation("com.squareup.okhttp3:mockwebserver:4.11.0")
}