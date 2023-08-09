package test.mandiri.application.mapper

import org.mapstruct.factory.Mappers
import test.mandiri.application.domain.model.GenreMapper
import test.mandiri.application.domain.model.GenreModel
import test.mandiri.module.rest.service.response.genre.Genre

class GenreModelMapperImpl : GenreModelMapper {

    private val mapper by lazy {
        Mappers.getMapper(GenreMapper::class.java)
    }

    override fun mapGenreDataToModel(genre: List<Genre>): List<GenreModel> =
        mapper.mapGenre(genre)
}