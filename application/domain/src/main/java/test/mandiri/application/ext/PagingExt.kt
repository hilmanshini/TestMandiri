package test.mandiri.application.ext

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlinx.coroutines.flow.Flow

fun <T : Any> paging(refreshKey: Int = 1, call: suspend (Int) -> Result<List<T>>): Flow<PagingData<T>> {
    return object : PagingSource<Int, T>() {
        override fun getRefreshKey(state: PagingState<Int, T>): Int? = refreshKey

        override suspend fun load(params: LoadParams<Int>): LoadResult<Int, T> {
            val key = params.key ?: 1
            val result = kotlin.runCatching {
                call(key).getOrThrow()
            }
            return if (result.isSuccess) {
                val list = result.getOrThrow()
                LoadResult.Page(
                    data = list,
                    prevKey = if (list.isEmpty()) null else (if(key == 1) null else key.minus(1)),
                    nextKey = if (list.isEmpty()) null else key.plus(1)
                )
            } else {
                LoadResult.Error(requireNotNull(result.exceptionOrNull()))
            }
        }

    }.run {
        Pager(
            config = PagingConfig(1),
            pagingSourceFactory = { this }
        ).flow
    }
}