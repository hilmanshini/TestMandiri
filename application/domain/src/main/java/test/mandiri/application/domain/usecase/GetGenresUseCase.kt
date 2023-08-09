package test.mandiri.application.domain.usecase

import test.mandiri.application.domain.model.GenreMapper
import test.mandiri.application.ext.useCase
import test.mandiri.application.mapper.GenreModelMapper
import test.mandiri.module.rest.service.remote.RemoteMovieService


class GetGenresUseCase(
    private val movieRemoteMovieService: RemoteMovieService,
    private val genreMapper: GenreModelMapper
) {

    operator fun invoke() = useCase {
        movieRemoteMovieService.getGenre().map {
            genreMapper.mapGenreDataToModel(it)
        }
    }
}