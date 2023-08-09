package test.mandiri.application.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import org.mapstruct.Mapper
import org.mapstruct.control.DeepClone
import test.mandiri.module.rest.service.response.review.AuthorDetails
import test.mandiri.module.rest.service.response.review.MovieReview
import test.mandiri.module.rest.service.response.video.MoviesVideo

@Parcelize
data class VideoModel(
    val id: String,
    val iso_3166_1: String?,
    val iso_639_1: String?,
    val key: String?,
    val name: String?,
    val official: Boolean?,
    val published_at: String?,
    val site: String?,
    val size: Int?,
    val type: String?
) : Parcelable

@Mapper(mappingControl = DeepClone::class)
interface VideoMapper {

    fun mapDataToModel(review: List<MoviesVideo>): List<VideoModel>
}