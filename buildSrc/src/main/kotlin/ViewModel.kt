import implementation
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.viewModel() {
    val lifecycle = "2.5.1"
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${lifecycle}")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:${lifecycle}")
    implementation("androidx.fragment:fragment-ktx:1.5.6")
}