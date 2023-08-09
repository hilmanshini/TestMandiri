package test.mandiri.module.rest.service.response.review

data class ReviewResponse(
    val id: Int,
    val page: Int,
    val results: List<MovieReview>,
    val total_pages: Int,
    val total_results: Int
)