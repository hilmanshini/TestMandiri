package test.mandiri.module.database

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import test.mandiri.module.database.dao.UsersFavoriteMovieDao
import test.mandiri.module.database.datasource.FavoredMovieLocalDataSource
import test.mandiri.module.database.db.MovieDb
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DbModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): MovieDb =
        MovieDb.create(context)

    @Singleton
    @Provides
    fun provideFavoredDao(movieDb: MovieDb) = movieDb.favoredMovieDao

    @Singleton
    @Provides
    fun favoredMovieLocalDataSource(usersFavoriteMovieDao: UsersFavoriteMovieDao) =
        FavoredMovieLocalDataSource(usersFavoriteMovieDao)
}