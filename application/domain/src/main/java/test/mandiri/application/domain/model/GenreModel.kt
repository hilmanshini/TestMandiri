package test.mandiri.application.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import org.mapstruct.Mapper
import org.mapstruct.control.DeepClone
import test.mandiri.module.rest.service.response.genre.Genre

@Parcelize
class GenreModel(
    val id: Int,
    val name: String
) : Parcelable

@Mapper(mappingControl = DeepClone::class)
interface GenreMapper {
    fun mapGenre(movieData: List<Genre>): List<GenreModel>
}