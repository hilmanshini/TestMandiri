package test.mandri.application.view.video

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import test.mandiri.application.view.R
import test.mandiri.application.view.databinding.VideoBinding
import test.mandri.application.view.ext.loadWhenReady
import test.mandri.application.view.ext.observe
import test.mandri.application.view.ext.observeData
import test.mandri.application.view.ext.observePaging
import test.mandri.application.view.ext.setView
import test.mandri.application.view.ext.withLoadStateListener

@AndroidEntryPoint
class VideoFragment : Fragment() {

    private val args by navArgs<VideoFragmentArgs>()
    private val videoViewModel by viewModels<VideoViewModel>()
    private val thumbadapter = VideoThumbnailAdapter {
        videoViewModel.selectedVideo.value = it
    }
    private val reviewAdapter = VideoReviewAdapter().withLoadStateListener(
        onError = {
            binding.reviewError = true
        },
        onProgress = {
            binding.reviewError = false
        }
    )
    lateinit var binding: VideoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        videoViewModel.movieData.value = args.movie
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = setView<VideoBinding>(inflater, container, R.layout.video).apply {
        binding = this
        vm = videoViewModel
        videoThumbRecycler.adapter = thumbadapter
        reviewRecycler.adapter = reviewAdapter
        lifecycle.addObserver(binding.ytPlayer)
        ytPlayer.enableAutomaticInitialization = true
        onToggleFavored = {
            videoViewModel.toggleFavorite()
        }
        onReviewRetry = {
            binding.reviewError = false
            reviewAdapter.retry()
        }
        onVideoLoadRetry = {
            videoViewModel.loadVideo()
        }
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData(videoViewModel.movieData) {
            videoViewModel.loadVideo()
            videoViewModel.loadReview()
            binding.favored = it.favored
        }
        observe(videoViewModel.videoModel, onFailure = {
            binding.videoLoadError = true
        }) {
            binding.videoLoadError = false
            thumbadapter.submitList(it)
            binding.ytPlayer.loadWhenReady(it.firstOrNull()?.key)
            videoViewModel.selectedVideo.value = it.firstOrNull()
        }
        observePaging(videoViewModel.reviewModel) {
            reviewAdapter.submitData(it)
        }
        observeData(videoViewModel.selectedVideo) {
            binding.ytPlayer.loadWhenReady(it.key)
        }
        observeData(videoViewModel.toggleFavoriteModel) { result ->
            videoViewModel.movieData.value?.let {
                it.favored = result.getOrThrow()
                binding.favored = it.favored
                videoViewModel.movieData.value = it
                videoViewModel.toggleFavoriteModel.value = null
            }
        }
    }


}