package test.mandiri.module.database.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import test.mandiri.module.database.dao.UsersFavoriteMovieDao
import test.mandiri.module.database.entity.UsersFavoredMovie


@Database(
    entities = [
        UsersFavoredMovie::class
    ],
    version = 1,
    exportSchema = false,
)
abstract class MovieDb : RoomDatabase() {
    abstract val favoredMovieDao: UsersFavoriteMovieDao

    companion object {
        fun create(context: Context): MovieDb {
            return Room.databaseBuilder(context, MovieDb::class.java, "Movie.db")
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}