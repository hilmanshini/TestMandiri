package test.mandiri.application.domain.usecase

import test.mandiri.application.domain.model.VideoMapper
import test.mandiri.application.ext.useCase
import test.mandiri.application.mapper.VideoModelMapper
import test.mandiri.module.rest.service.remote.RemoteMovieService

class GetVideoByMovieIdUseCase(
    private val movieRemoteMovieService: RemoteMovieService,
    private val videoMapper: VideoModelMapper
) {

    operator fun invoke(movieId: Long) = useCase {
        movieRemoteMovieService.getMoviesVideo(movieId).map {
            videoMapper.mapVideoToModel(it)
        }
    }
}