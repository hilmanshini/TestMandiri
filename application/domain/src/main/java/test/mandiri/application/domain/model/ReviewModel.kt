package test.mandiri.application.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import org.mapstruct.Mapper
import org.mapstruct.control.DeepClone
import test.mandiri.module.rest.service.response.review.AuthorDetails
import test.mandiri.module.rest.service.response.review.MovieReview

@Parcelize
data class ReviewModel(
    val author: String?,
    val author_details: AuthorModel?,
    val content: String?,
    val created_at: String?,
    val id: String?,
    val updated_at: String?,
    val url: String?
) : Parcelable


@Parcelize
data class AuthorModel(
    val avatar_path: String?,
    val name: String?,
    val rating: String?,
    val username: String?
) : Parcelable


@Mapper(mappingControl = DeepClone::class)
interface ReviewMapper {

    fun mapReviewDataToModel(review: List<MovieReview>): List<ReviewModel>

    fun mapAuthorDataToModel(authorDetails: AuthorDetails): AuthorModel
}