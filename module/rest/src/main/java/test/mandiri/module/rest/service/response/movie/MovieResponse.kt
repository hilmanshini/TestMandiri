package test.mandiri.module.rest.service.response.movie


data class MovieResponse(
    val page: Int,
    val results: List<MovieData>,
    val total_pages: Int,
    val total_results: Int
)