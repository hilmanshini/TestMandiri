import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.ProjectDependency
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.debugImplementation(s: String) {
    add("debugImplementation", s)
}

fun DependencyHandler.implementation(s: String) {
    add("implementation", s)
}

fun DependencyHandler.implementation(vararg s: String) {
    s.forEach {
        implementation(it)
    }
}

fun DependencyHandler.implementation(s: Dependency) {
    add("implementation", s)
}

fun DependencyHandler.testImplementation(s: String) {
    add("testImplementation", s)
}

fun DependencyHandler.testImplementation(s: Dependency) {
    add("testImplementation", s)
}

fun DependencyHandler.androidTestImplementation(s: String) {
    add("androidTestImplementation", s)
}

fun DependencyHandler.androidTestImplementation(vararg s: String) {
    s.forEach {
        androidTestImplementation(it)
    }
}

fun DependencyHandler.kapt(s: String) {
    add("kapt", s)
}

fun DependencyHandler.kaptAndroidTest(s: String) {
    add("kaptAndroidTest", s)
}

fun DependencyHandler.kaptTest(s: String) {
    add("kaptTest", s)
}

fun DependencyHandler.api(s: String) {
    add("api", s)
}


fun DependencyHandler.project(
    path: String,
    configuration: String? = null
): ProjectDependency =

    project(
        if (configuration != null) mapOf("path" to path, "configuration" to configuration)
        else mapOf("path" to path)
    ) as ProjectDependency

