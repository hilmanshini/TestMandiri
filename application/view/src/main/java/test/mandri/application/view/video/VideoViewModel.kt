package test.mandri.application.view.video

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import test.mandiri.application.domain.model.MovieModel
import test.mandiri.application.domain.model.ReviewModel
import test.mandiri.application.domain.model.VideoModel
import test.mandiri.application.domain.usecase.GetReviewByMovieId
import test.mandiri.application.domain.usecase.GetVideoByMovieIdUseCase
import test.mandiri.application.domain.usecase.ToggleMovieFavoredUseCase
import javax.inject.Inject

@HiltViewModel
class VideoViewModel @Inject constructor(
    val getReviewByMovieId: GetReviewByMovieId,
    val getVideoByMovieIdUseCase: GetVideoByMovieIdUseCase,
    val toggleMovieFavoredUseCase: ToggleMovieFavoredUseCase
) : ViewModel() {

    val movieData = MutableStateFlow<MovieModel?>(null)
    val videoModel = MutableStateFlow<Result<List<VideoModel>>?>(null)
    val reviewModel = MutableStateFlow<PagingData<ReviewModel>?>(null)
    val selectedVideo = MutableStateFlow<VideoModel?>(null)
    val toggleFavoriteModel = MutableStateFlow<Result<Boolean>?>(null)

    fun loadVideo() {
        viewModelScope.launch {
            getVideoByMovieIdUseCase(movieData.value?.id ?: 0).collect {
                videoModel.value = it
            }
        }
    }

    fun loadReview() {
        viewModelScope.launch {
            getReviewByMovieId(movieData.value?.id ?: 0).cachedIn(viewModelScope).collect {
                reviewModel.value = it
            }
        }
    }

    fun toggleFavorite() {
        viewModelScope.launch {
            movieData.value?.let {
                toggleMovieFavoredUseCase(it.id).collect {
                    toggleFavoriteModel.value = it
                }
            }
        }
    }

}