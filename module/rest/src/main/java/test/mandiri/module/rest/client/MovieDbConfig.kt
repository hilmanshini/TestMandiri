package test.mandiri.module.rest.client

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import java.time.Duration

@Module
@InstallIn(SingletonComponent::class)
class MovieDbConfig {

    @Provides
    @Named("movieDbApiKey")
    fun provideMovieDbKey() = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwMWEzMDIzMDBlN2ZiYzlmYjdmMGFmNGUxODM5OTM4OCIsInN1YiI6IjYyNjhiMGM0MTU4Yzg1MDA2NmJkMzg5NCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.hsjuoKXZGzsM7KOu48dvfEPvidlhuG9xsYUmolbJ7WM"


    @Provides
    @Named("readTimeout")
    fun provideReadTimeout(): Duration = Duration.ofMinutes(5)

    @Provides
    @Named("writeTimeout")
    fun provideWriteTimeout(): Duration = Duration.ofMinutes(1)

    @Provides
    @Named("baseUrl")
    fun provideBaseUrl() = "https://api.themoviedb.org/3/"

}