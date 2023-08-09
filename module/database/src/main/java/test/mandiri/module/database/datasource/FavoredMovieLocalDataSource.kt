package test.mandiri.module.database.datasource

import test.mandiri.module.database.dao.UsersFavoriteMovieDao

class FavoredMovieLocalDataSource(private val usersFavoriteMovieDao: UsersFavoriteMovieDao) {

    suspend fun getFavoredMovie(ids: List<Long>) =
        usersFavoriteMovieDao.getFavoredMovies(ids.toTypedArray()).run {
            ids.map {
                it to this.contains(it)
            }.toMap()
        }

    suspend fun toggleMovieFavored(id: Long) = runCatching {
        usersFavoriteMovieDao.getFavoredMovie(id)?.let {
            usersFavoriteMovieDao.unsetFavoriteMovie(it.id)
            false
        } ?: run {
            usersFavoriteMovieDao.unsetFavoriteMovie(id)
            true
        }
    }

}