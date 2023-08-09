package test.mandiri.module.rest.service

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import test.mandiri.module.rest.service.response.genre.GenreResponse
import test.mandiri.module.rest.service.response.movie.MovieResponse
import test.mandiri.module.rest.service.response.review.ReviewResponse
import test.mandiri.module.rest.service.response.video.MoviesVideoResponse

interface MovieRestService {

    @GET("discover/movie")
    suspend fun getMovieByGenre(
        @Query("with_genres") genres: String,
        @Query("page") page: Int = 1
    ): Response<MovieResponse>

    @GET("genre/movie/list")
    suspend fun getAllGenre(
    ): Response<GenreResponse>

    @GET("movie/{movie_id}/reviews")
    suspend fun getMovieReviews(
        @Path("movie_id") movieId: Long,
        @Query("page") page: Int = 1
    ): Response<ReviewResponse>

    @GET("movie/{movie_id}/videos")
    suspend fun getMoviesVideo(
        @Path("movie_id") movie_id: Long
    ) : Response<MoviesVideoResponse>
}