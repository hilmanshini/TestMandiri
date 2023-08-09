package test.mandiri.application.domain.usecase

import test.mandiri.application.ext.paging
import test.mandiri.application.mapper.MovieModelMapper
import test.mandiri.module.database.datasource.FavoredMovieLocalDataSource
import test.mandiri.module.rest.service.remote.RemoteMovieService

class GetMovieByGenreUseCase(
    private val remoteMovieService: RemoteMovieService,
    private val usersFavoriteMovieDao: FavoredMovieLocalDataSource,
    private val mapper: MovieModelMapper
) {


    operator fun invoke(genreIds: Array<Int>) = paging { page ->
        remoteMovieService.getMovieByGenre(page, genreIds).map {
            val favored = usersFavoriteMovieDao.getFavoredMovie(it.map { it.id ?: 0 })
            mapper.mapModelWithFavored(it, favored)
        }
    }
}