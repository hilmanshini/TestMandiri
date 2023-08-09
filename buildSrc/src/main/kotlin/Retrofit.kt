import implementation
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.retrofit() {
    val version = "2.9.0"
    implementation(
        "com.squareup.retrofit2:retrofit:$version",
        "com.squareup.retrofit2:converter-gson:$version",
        "com.squareup.retrofit2:converter-moshi:$version"
    )
}