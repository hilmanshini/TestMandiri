package test.mandiri.application.domain.usecase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.mapstruct.factory.Mappers
import test.mandiri.application.domain.model.GenreMapper
import test.mandiri.application.domain.model.ReviewMapper
import test.mandiri.application.domain.model.VideoMapper
import test.mandiri.application.mapper.GenreModelMapper
import test.mandiri.application.mapper.MovieModelMapper
import test.mandiri.application.mapper.ReviewModelMapper
import test.mandiri.application.mapper.VideoModelMapper
import test.mandiri.module.database.datasource.FavoredMovieLocalDataSource
import test.mandiri.module.rest.service.remote.RemoteMovieService

@Module
@InstallIn(SingletonComponent::class)
class _Module {


    @Provides
    fun provideGenreUseCase(
        movieRemoteMovieService: RemoteMovieService,
        genreMapper: GenreModelMapper
    ) = GetGenresUseCase(movieRemoteMovieService, genreMapper)


    @Provides
    fun provideMovieUseCase(
        remoteMovieService: RemoteMovieService,
        usersFavoriteMovieDao: FavoredMovieLocalDataSource,
        mapper: MovieModelMapper
    ) = GetMovieByGenreUseCase(remoteMovieService, usersFavoriteMovieDao, mapper)

    @Provides
    fun provideReviewUseCase(
        movieRemoteMovieService: RemoteMovieService,
        reviewMapper: ReviewModelMapper
    ) =
        GetReviewByMovieId(movieRemoteMovieService, reviewMapper)

    @Provides
    fun provideVideoUseCase(movieRemoteMovieService: RemoteMovieService, videoMapper: VideoModelMapper) =
        GetVideoByMovieIdUseCase(movieRemoteMovieService, videoMapper)

    @Provides
    fun provideToggleFavorite(favoredMovieLocalDataSource: FavoredMovieLocalDataSource) =
        ToggleMovieFavoredUseCase(
            favoredMovieLocalDataSource
        )
}