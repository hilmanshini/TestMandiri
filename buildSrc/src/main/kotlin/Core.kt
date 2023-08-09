import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.core() {
    implementation(
        "androidx.core:core-ktx:1.8.0",
        "androidx.appcompat:appcompat:1.6.1",
        "com.google.android.material:material:1.9.0"
    )

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation(
        "androidx.test.ext:junit:1.1.5",
        "androidx.test.espresso:espresso-core:3.5.1"
    )
}