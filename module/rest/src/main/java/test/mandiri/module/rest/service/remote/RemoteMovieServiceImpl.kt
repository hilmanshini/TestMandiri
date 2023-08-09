package test.mandiri.module.rest.service.remote

import test.mandiri.module.rest.client.TheMovieDbRestClient
import test.mandiri.module.rest.ext.restApi
import test.mandiri.module.rest.service.MovieRestService
import test.mandiri.module.rest.service.response.genre.Genre
import test.mandiri.module.rest.service.response.genre.GenreResponse
import test.mandiri.module.rest.service.response.movie.MovieData
import test.mandiri.module.rest.service.response.review.MovieReview
import test.mandiri.module.rest.service.response.video.MoviesVideo

class RemoteMovieServiceImpl(
    private val restService: MovieRestService
) : RemoteMovieService {


    override suspend fun getMovieByGenre(
        page: Int,
        genres: Array<Int>
    ): Result<List<MovieData>> = restApi {
        restService.getMovieByGenre(genres.joinToString(","), page)
    }.map {
        it.results
    }


    override suspend fun getGenre() = restApi {
        restService.getAllGenre()
    }.map {
        it.genres
    }

    override suspend fun getMovieReview(movieId: Long, page: Int): Result<List<MovieReview>> =
        restApi {
            restService.getMovieReviews(movieId, page)
        }.map {
            it.results
        }

    override suspend fun getMoviesVideo(movie_id: Long): Result<List<MoviesVideo>> = restApi {
        restService.getMoviesVideo(movie_id)
    }.map {
        it.results
    }

}