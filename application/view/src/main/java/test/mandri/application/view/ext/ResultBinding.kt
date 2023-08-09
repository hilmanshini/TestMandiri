package test.mandri.application.view.ext

import android.view.View
import androidx.databinding.BindingAdapter

fun <T> isError(result: Result<T>?): Boolean {
    return result?.isFailure ?: false
}

fun <T : Any> getData(result: Result<List<T>>?): List<T>? {
    return if (result?.isSuccess == true) {
        result.getOrThrow()
    } else {
        null
    }
}

@BindingAdapter("setEnabled")
fun View.st(any:Boolean) {
    this.isEnabled = any
}
