package test.mandri.application.view.ext

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

@Suppress("UNCHECKED_CAST")
@BindingAdapter("adapterData")
fun <T> RecyclerView.adapter(list: List<T>?) {
    this.adapter?.let { adapter ->
        list?.let {
            (adapter as? ListAdapter<T, *>)?.submitList(list)
        }
    }
}