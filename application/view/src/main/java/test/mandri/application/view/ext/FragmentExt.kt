package test.mandri.application.view.ext

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

inline fun <reified T : ViewDataBinding> Fragment.setView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    layoutId: Int
) =
    DataBindingUtil.inflate<T>(inflater, layoutId, container, false).apply {
        this.lifecycleOwner = viewLifecycleOwner
    }

fun <T> Fragment.observeData(
    flow:MutableStateFlow<T?>,
    call:suspend (T)->Unit
){
    lifecycleScope.launch {
        flow.collect{
            it?.let {
                call(it)
            }
        }
    }
}


fun <T:Any> Fragment.observePaging(
    flow: MutableStateFlow<PagingData<T>?>,
    call:suspend (PagingData<T>)->Unit
) {
    lifecycleScope.launch {
        flow.collect{
            it?.let {
                call(it)
            }
        }
    }
}

fun <T> Fragment.observe(
    flow: MutableStateFlow<Result<T>?>,
    onLoading: () -> Unit = {},
    onFailure: (Throwable) -> Unit = {},
    onSuccess: (T) -> Unit = {},
) {
    lifecycleScope.launch {
        flow.collect {
            when {
                it == null -> {
                    onLoading()
                }
                it.isSuccess -> {
                    onSuccess(it.getOrThrow())
                }

                it.isFailure -> {
                    it.exceptionOrNull()?.let(onFailure)
                }
            }
        }
    }
}