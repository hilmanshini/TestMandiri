package test.mandri.application.view.genre

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import test.mandiri.application.domain.model.GenreModel
import test.mandiri.application.domain.usecase.GetGenresUseCase
import javax.inject.Inject

@HiltViewModel
class GenreViewModel @Inject constructor(
    val genresUseCase: GetGenresUseCase
) : ViewModel() {

    val selection = MutableStateFlow<List<GenreModel>>(listOf())
    val genreFlow = MutableStateFlow<Result<List<GenreModel>>?>(null)

    init {
        loadGenre()
    }

    fun isEmpty(): Boolean {
        return selection.value.isEmpty()
    }

    fun loadGenre() {
        genreFlow.value = null
        viewModelScope.launch {
            genresUseCase().collect {
                genreFlow.value = it
            }
        }
    }
}