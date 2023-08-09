package test.mandri.application.view.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import test.mandiri.application.view.R
import test.mandiri.application.view.databinding.MovieBinding
import test.mandri.application.view.ext.observeData
import test.mandri.application.view.ext.setView
import test.mandri.application.view.ext.withLoadStateListener

@AndroidEntryPoint
class MovieFragment : Fragment() {

    private val args: MovieFragmentArgs by navArgs()

    private val movieViewModel by viewModels<MovieViewModel>()
    private lateinit var binding: MovieBinding

    val adapter = MovieAdapter {
        findNavController().navigate(MovieFragmentDirections.actionMovieFragmentToVideoFragment(it))
    }.withLoadStateListener(onError = {
        binding.error = true
    }, onProgress = {
        binding.error = false
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieViewModel.genres.value = args.genres
        movieViewModel.loadMovies()
        observeData(movieViewModel.moviePager) {
            adapter.submitData(it)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = setView<MovieBinding>(inflater, container, R.layout.movie).apply {
        binding = this
        vm = movieViewModel
        recycler.adapter = adapter
        onRetry = {
            adapter.retry()
        }
    }.root
}