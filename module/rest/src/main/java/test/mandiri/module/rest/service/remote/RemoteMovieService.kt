package test.mandiri.module.rest.service.remote

import test.mandiri.module.rest.service.response.genre.Genre
import test.mandiri.module.rest.service.response.movie.MovieData
import test.mandiri.module.rest.service.response.review.MovieReview
import test.mandiri.module.rest.service.response.video.MoviesVideo

interface RemoteMovieService {

    suspend fun getMovieByGenre(page: Int, genres: Array<Int>): Result<List<MovieData>>
    suspend fun getGenre(): Result<List<Genre>>
    suspend fun getMovieReview(movieId: Long, page: Int = 1): Result<List<MovieReview>>
    suspend fun getMoviesVideo(movie_id: Long): Result<List<MoviesVideo>>
}