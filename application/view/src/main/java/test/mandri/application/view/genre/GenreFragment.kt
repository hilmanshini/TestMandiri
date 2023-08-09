package test.mandri.application.view.genre

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import test.mandiri.application.view.BR
import test.mandiri.application.view.R
import test.mandiri.application.view.databinding.GenreBinding
import test.mandri.application.view.ext.observe
import test.mandri.application.view.ext.setView

@AndroidEntryPoint
class GenreFragment : Fragment() {

    private val genreViewModel: GenreViewModel by viewModels()
    private lateinit var binding: GenreBinding

    private val genreAdapter = GenreAdapter {
        genreViewModel.selection.value = it
        binding.empty = it.isEmpty()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            genreViewModel.selection.collect {
                genreAdapter.setSelection(it)
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = setView<GenreBinding>(inflater, container, R.layout.genre).apply {
        binding = this
        recycler.adapter = genreAdapter
        vm = genreViewModel
        onRetry = { genreViewModel.loadGenre() }
        binding.empty = genreAdapter.isEmptySelection()
        onSubmit = {
            findNavController().navigate(
                GenreFragmentDirections.actionGenreFragmentToMovieFragment(
                    genreAdapter.getSelection().toTypedArray()
                )
            )
        }
    }.root


}