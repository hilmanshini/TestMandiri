package test.mandri.application.view.genre

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import test.mandiri.application.domain.model.GenreModel
import test.mandiri.application.view.databinding.GenreItemBinding

class GenreAdapter(
    private val differ: Differ = Differ(),
    val onSelectionChanged: (List<GenreModel>) -> Unit
) :
    ListAdapter<GenreModel, GenreViewHolder>(differ) {

    private val adapterSelection: MutableList<GenreModel> = mutableListOf()

    class Differ : ItemCallback<GenreModel>() {
        override fun areItemsTheSame(oldItem: GenreModel, newItem: GenreModel): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: GenreModel, newItem: GenreModel): Boolean =
            true
    }

    fun setSelection(selection: List<GenreModel>) {
        adapterSelection.clear()
        adapterSelection.addAll(selection)
        submitList(currentList)
    }

    fun getSelection() = adapterSelection

    fun isEmptySelection() = adapterSelection.isEmpty()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder =
        GenreViewHolder(
            GenreItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ) {
            val selection = currentList[it]
            adapterSelection.find {
                selection.id == it.id
            }?.let {
                adapterSelection.remove(it)
            } ?: run {
                adapterSelection.add(selection)
            }
            notifyItemChanged(it)
            onSelectionChanged(adapterSelection)
        }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        val item = currentList[position]
        val selected = adapterSelection.find { it.id == item.id }
        holder.bind(currentList[position], selected != null)
    }


}

class GenreViewHolder(val binding: GenreItemBinding, onItemClick: (Int) -> Unit) :
    ViewHolder(binding.root) {
    init {
        binding.root.setOnClickListener {
            onItemClick(layoutPosition)
        }
    }

    fun bind(genreModel: GenreModel, selected: Boolean) {
        binding.name = genreModel.name
        binding.selected = selected
    }
}