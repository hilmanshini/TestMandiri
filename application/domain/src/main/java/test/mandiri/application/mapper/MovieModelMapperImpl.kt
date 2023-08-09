package test.mandiri.application.mapper

import org.mapstruct.factory.Mappers
import test.mandiri.application.domain.model.MovieMapper
import test.mandiri.application.domain.model.MovieModel
import test.mandiri.module.rest.service.response.movie.MovieData

class MovieModelMapperImpl : MovieModelMapper {

    private val mapper by lazy {
        Mappers.getMapper(MovieMapper::class.java)
    }

    override fun mapModelWithFavored(
        list: List<MovieData>,
        favored: Map<Long, Boolean>
    ): List<MovieModel> =
        list.map {
            mapper.mapMovieDataToModel(it).run {
                this.favored = favored[this.id] ?: false
                this
            }
        }


}