import implementation
import kapt
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.moshi() {
	val moshi = "1.14.0"
	implementation("com.squareup.moshi:moshi:$moshi")
	kapt("com.squareup.moshi:moshi-kotlin-codegen:$moshi")
}