package test.mandiri.application.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import org.mapstruct.Mapper
import org.mapstruct.control.DeepClone
import test.mandiri.module.rest.service.response.movie.MovieData

@Parcelize
class MovieModel(
    val adult: Boolean,
    val backdrop_path: String?,
    val genre_ids: List<Int>?,
    val id: Long,
    val original_language: String?,
    val original_title: String?,
    val overview: String?,
    val popularity: Double?,
    val poster_path: String?,
    val release_date: String?,
    val title: String,
    val video: Boolean,
    val vote_average: Double?,
    val vote_count: Int?,
    var favored: Boolean
): Parcelable


@Mapper(mappingControl = DeepClone::class)
interface MovieMapper {
    fun mapMovieDataToModel(movieData: MovieData): MovieModel
}