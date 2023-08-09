package test.mandiri.application.mapper

import test.mandiri.application.domain.model.MovieModel
import test.mandiri.module.rest.service.response.movie.MovieData

interface MovieModelMapper {


    fun mapModelWithFavored(list: List<MovieData>, favored: Map<Long, Boolean>): List<MovieModel>

}