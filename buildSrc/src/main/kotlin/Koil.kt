import implementation
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.koil(){
    implementation("io.coil-kt:coil:2.3.0")
    implementation("io.coil-kt:coil-compose:2.3.0")

}

