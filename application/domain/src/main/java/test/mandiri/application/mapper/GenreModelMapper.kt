package test.mandiri.application.mapper

import test.mandiri.application.domain.model.GenreModel
import test.mandiri.module.rest.service.response.genre.Genre

interface GenreModelMapper {

    fun mapGenreDataToModel(genre: List<Genre>): List<GenreModel>
}