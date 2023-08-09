package test.mandiri.module.rest.service

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import test.mandiri.module.rest.client.TheMovieDbRestClient
import test.mandiri.module.rest.service.remote.RemoteMovieService
import test.mandiri.module.rest.service.remote.RemoteMovieServiceImpl
import java.time.Duration
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Module {

    @Provides
    fun provideRestClient(
        @Named("movieDbApiKey")
        apiKey: String,
        @Named("readTimeout")
        readTimeout: Duration,
        @Named("writeTimeout")
        writeTimeout: Duration,
        @Named("baseUrl")
        baseUrl: String
    ) =
        TheMovieDbRestClient(apiKey, readTimeout, writeTimeout, baseUrl)

    @Provides
    @Singleton
    fun provideMovieRestService(theMovieDbRestClient: TheMovieDbRestClient) =
        theMovieDbRestClient.create(MovieRestService::class.java)

    @Provides
    @Singleton
    fun provideMoveRemoteService(moveRestService: MovieRestService): RemoteMovieService =
        RemoteMovieServiceImpl(moveRestService)
}