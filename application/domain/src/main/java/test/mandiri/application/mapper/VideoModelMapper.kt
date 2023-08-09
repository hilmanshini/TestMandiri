package test.mandiri.application.mapper

import test.mandiri.application.domain.model.VideoModel
import test.mandiri.module.rest.service.response.video.MoviesVideo

interface VideoModelMapper {
    fun mapVideoToModel(list: List<MoviesVideo>): List<VideoModel>
}