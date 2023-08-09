import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.mapStruct() {
    val mapstructVersion = "1.5.5.Final"
    implementation("org.mapstruct:mapstruct:${mapstructVersion}")
    kapt("org.mapstruct:mapstruct-processor:${mapstructVersion}")
}