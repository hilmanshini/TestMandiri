package test.mandiri.application.mapper

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class _Module {

    @Provides
    fun provideGenreMapper(): GenreModelMapper = GenreModelMapperImpl()


    @Provides
    fun provideMovieMapper(): MovieModelMapper = MovieModelMapperImpl()

    @Provides
    fun provideReviewMapper(): ReviewModelMapper = ReviewModelMapperImpl()

    @Provides
    fun provideVideoMapper(): VideoModelMapper = VideoModelMapperImpl()
}