package test.mandri.application.view.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import test.mandiri.application.domain.model.MovieModel
import test.mandiri.application.view.databinding.GenreItemBinding
import test.mandiri.application.view.databinding.MovieItemBinding

class MovieAdapter(private val onItemClick: (MovieModel) -> Unit) :
    PagingDataAdapter<MovieModel, MovieViewHolder>(Differ) {

    object Differ : ItemCallback<MovieModel>() {
        override fun areItemsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean =
            true
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(
            MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        ) {
            getItem(it)?.let(onItemClick)
        }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) =
        holder.bind(getItem(position))
}

class MovieViewHolder(val binding: MovieItemBinding, onItemClick: (Int) -> Unit) :
    RecyclerView.ViewHolder(binding.root) {
    init {
        binding.root.setOnClickListener {
            onItemClick(layoutPosition)
        }
    }

    fun bind(movieModel: MovieModel?) {
        binding.item = movieModel
    }
}