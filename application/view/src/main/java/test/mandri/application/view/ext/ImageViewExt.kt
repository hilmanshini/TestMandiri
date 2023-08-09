package test.mandri.application.view.ext

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.ImageLoader
import coil.load
import test.mandiri.application.view.R

@BindingAdapter("load", "loadPrefix")
fun ImageView.load(src: String?, prefix: String) {
    src?.let {
        this.load(prefix + src) {
            placeholder(R.drawable.movie_loading)
            diskCacheKey(src)
            crossfade(true)
            listener(
                onError = { r, e ->
                    setImageResource(R.drawable.movie_loading)
                },
                onStart = {
                    setImageResource(R.drawable.movie_loading)
                }
            )
        }
    } ?: kotlin.run {
        setImageResource(R.drawable.movie_loading)
    }
}