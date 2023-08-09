package test.mandiri.application.mapper

import org.mapstruct.factory.Mappers
import test.mandiri.application.domain.model.ReviewMapper
import test.mandiri.application.domain.model.VideoMapper
import test.mandiri.application.domain.model.VideoModel
import test.mandiri.module.rest.service.response.video.MoviesVideo

class VideoModelMapperImpl : VideoModelMapper {

    private val mapper by lazy {
        Mappers.getMapper(VideoMapper::class.java)
    }

    override fun mapVideoToModel(list: List<MoviesVideo>): List<VideoModel> =
        mapper.mapDataToModel(list)
}