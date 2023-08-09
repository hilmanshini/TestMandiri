import implementation
import org.gradle.api.artifacts.dsl.DependencyHandler
import testImplementation

fun DependencyHandler.paging(){
    val paging_version = "3.1.1"
    implementation("androidx.paging:paging-runtime:$paging_version")
    testImplementation("androidx.paging:paging-common:$paging_version")
    implementation( "androidx.paging:paging-compose:1.0.0-alpha19")
}