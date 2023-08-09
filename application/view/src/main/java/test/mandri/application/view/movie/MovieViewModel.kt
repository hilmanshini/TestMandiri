package test.mandri.application.view.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import test.mandiri.application.domain.model.GenreModel
import test.mandiri.application.domain.model.MovieModel
import test.mandiri.application.domain.usecase.GetMovieByGenreUseCase
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    val getMovieByGenreUseCase: GetMovieByGenreUseCase
) : ViewModel() {

    val genres = MutableStateFlow<Array<GenreModel>>(emptyArray())

    val moviePager = MutableStateFlow<PagingData<MovieModel>?>(null)

    fun loadMovies() {
        viewModelScope.launch {
            getMovieByGenreUseCase(genres.value.map { it.id }.toTypedArray()).cachedIn(viewModelScope).collect {
                moviePager.value = it
            }
        }

    }
}