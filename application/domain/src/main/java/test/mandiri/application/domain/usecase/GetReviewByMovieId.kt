package test.mandiri.application.domain.usecase

import test.mandiri.application.domain.model.ReviewMapper
import test.mandiri.application.ext.paging
import test.mandiri.application.mapper.ReviewModelMapper
import test.mandiri.module.rest.service.remote.RemoteMovieService

class GetReviewByMovieId(
    private val movieRemoteMovieService: RemoteMovieService,
    private val reviewMapper: ReviewModelMapper
) {

    operator fun invoke(movieId: Long) = paging { page ->
        movieRemoteMovieService.getMovieReview(movieId, page).map {
            reviewMapper.mapModelWithData(it)
        }
    }
}