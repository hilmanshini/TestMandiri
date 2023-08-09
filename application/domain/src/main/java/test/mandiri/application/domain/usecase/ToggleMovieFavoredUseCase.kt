package test.mandiri.application.domain.usecase

import test.mandiri.application.ext.useCase
import test.mandiri.module.database.datasource.FavoredMovieLocalDataSource

class ToggleMovieFavoredUseCase(private val favoredMovieLocalDataSource: FavoredMovieLocalDataSource) {

    operator fun invoke(id:Long) = useCase{
        favoredMovieLocalDataSource.toggleMovieFavored(id)
    }
}