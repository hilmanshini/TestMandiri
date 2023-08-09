package test.mandri.application.view.video

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import test.mandiri.application.domain.model.VideoModel
import test.mandiri.application.view.databinding.VideoThumbItemBinding

class VideoThumbnailAdapter(
    private val onItemClick: (VideoModel) -> Unit
) : ListAdapter<VideoModel, VideoThumbViewHolder>(Differ) {


    object Differ : ItemCallback<VideoModel>() {
        override fun areItemsTheSame(oldItem: VideoModel, newItem: VideoModel): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: VideoModel, newItem: VideoModel): Boolean = true

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoThumbViewHolder =
        VideoThumbViewHolder(
            VideoThumbItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        ) {
            onItemClick.invoke(currentList[it])
        }

    override fun onBindViewHolder(holder: VideoThumbViewHolder, position: Int) =
        holder.bind(currentList[position])

}

class VideoThumbViewHolder(val binding: VideoThumbItemBinding, val onItemClick: (Int) -> Unit) :
    ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener {
            onItemClick(layoutPosition)
        }
    }

    fun bind(item: VideoModel) {
        binding.src = "https://img.youtube.com/vi/${item.key}/0.jpg"
    }

}