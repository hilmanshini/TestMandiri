package test.mandiri.module.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import test.mandiri.module.database.entity.UsersFavoredMovie


@Dao
interface UsersFavoriteMovieDao {


    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun setFavoriteMovie(usersFavoredMovie: UsersFavoredMovie)

    @Query("DELETE FROM UsersFavoredMovie where id = :id")
    suspend fun unsetFavoriteMovie(id: Long)

    @Query("select id from UsersFavoredMovie where id in (:ids)")
    suspend fun getFavoredMovies(ids: Array<Long>): List<Long>

    @Query("select id from UsersFavoredMovie where id = :id")
    suspend fun getFavoredMovie(id: Long): UsersFavoredMovie?

}