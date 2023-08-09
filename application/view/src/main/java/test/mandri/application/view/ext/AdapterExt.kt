package test.mandri.application.view.ext

import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView

fun <T : Any, VH : RecyclerView.ViewHolder> PagingDataAdapter<T, VH>.withLoadStateListener(
    onEmpty: () -> Unit = {},
    onError: () -> Unit = {},
    onProgress:()->Unit = {}
): PagingDataAdapter<T, VH> {
    addLoadStateListener { loadState ->

        if (loadState.append.endOfPaginationReached && itemCount < 1) {
            onEmpty()
        } else if (loadState.refresh is LoadState.Error) {
            onError()
        } else if (loadState.refresh is LoadState.NotLoading) {
            onProgress()
        }
    }
    return this
}