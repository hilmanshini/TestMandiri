package test.mandri.application.view.video

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import test.mandiri.application.domain.model.ReviewModel
import test.mandiri.application.view.databinding.VideoReviewBinding

class VideoReviewAdapter : PagingDataAdapter<ReviewModel, VideoReviewViewHolder>(Differ) {
    object Differ : ItemCallback<ReviewModel>() {
        override fun areItemsTheSame(oldItem: ReviewModel, newItem: ReviewModel): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: ReviewModel, newItem: ReviewModel): Boolean =
            true
    }

    override fun onBindViewHolder(holder: VideoReviewViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoReviewViewHolder =
        VideoReviewViewHolder(
            VideoReviewBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
}

class VideoReviewViewHolder(val binding: VideoReviewBinding) : ViewHolder(binding.root) {

    fun bind(reviewModel: ReviewModel) {
        binding.item = reviewModel
    }

}