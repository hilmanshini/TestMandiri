package test.mandiri.application.mapper

import org.mapstruct.factory.Mappers
import test.mandiri.application.domain.model.ReviewMapper
import test.mandiri.application.domain.model.ReviewModel
import test.mandiri.module.rest.service.response.review.MovieReview

class ReviewModelMapperImpl : ReviewModelMapper {

    private val mapper by lazy {
        Mappers.getMapper(ReviewMapper::class.java)
    }

    override fun mapModelWithData(list: List<MovieReview>): List<ReviewModel> =
        mapper.mapReviewDataToModel(list)

}