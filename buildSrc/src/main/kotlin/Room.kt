import implementation
import kapt
import org.gradle.api.artifacts.dsl.DependencyHandler
import testImplementation

fun DependencyHandler.room() {
	val version = "2.5.1"
	implementation("androidx.room:room-ktx:$version")
	implementation("androidx.room:room-runtime:$version")
	kapt("androidx.room:room-compiler:$version")
	testImplementation("androidx.room:room-testing:$version")
}

fun DependencyHandler.roomNoKapt(){
	val version = "2.5.1"
	implementation("androidx.room:room-ktx:$version")
}