package test.mandiri.application.mapper

import test.mandiri.application.domain.model.ReviewModel
import test.mandiri.module.rest.service.response.review.MovieReview

interface ReviewModelMapper {

    fun mapModelWithData(list: List<MovieReview>): List<ReviewModel>
}