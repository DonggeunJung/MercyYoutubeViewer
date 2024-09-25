package com.vclip.mercy.presentation.view.videoplay

import android.content.res.Configuration
import android.os.Build
import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.loadOrCueVideo
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import com.vclip.mercy.R
import com.vclip.mercy.data.YtVideo
import com.vclip.mercy.databinding.FragmentVideoPlayBinding

class VideoPlayFragment : Fragment() {
    private lateinit var binding: FragmentVideoPlayBinding
    lateinit var youTubePlayerView: YouTubePlayerView
    private var video: YtVideo? = null

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(arguments?.containsKey(VIDEO_DATA) == true) {
            video = if(SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                arguments?.getParcelable(VIDEO_DATA, YtVideo::class.java)
            } else {
                arguments?.getParcelable(VIDEO_DATA)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentVideoPlayBinding.inflate(inflater)
        video?.let {
            initYouTubePlayerView(it)
        }
        return binding.root
    }

    private fun initYouTubePlayerView(video: YtVideo) {
        youTubePlayerView = binding.youtubePlayerView
        lifecycle.addObserver(youTubePlayerView)

        val listener: YouTubePlayerListener = object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                val customPlayerUi = youTubePlayerView.inflateCustomPlayerUi(R.layout.custom_player_ui)
                val customPlayerUiController = CustomPlayerUiController(
                    context,
                    customPlayerUi,
                    youTubePlayer,
                    youTubePlayerView
                )
                youTubePlayer.addListener(customPlayerUiController)
                youTubePlayer.loadOrCueVideo(lifecycle, video.id, video.startSeconds.toFloat())
            }
        }

        val options: IFramePlayerOptions = IFramePlayerOptions.Builder().controls(0).build()
        youTubePlayerView.initialize(listener, options)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        // Checks the orientation of the screen
        when(newConfig.orientation) {
            Configuration.ORIENTATION_LANDSCAPE -> youTubePlayerView.matchParent()
            Configuration.ORIENTATION_PORTRAIT -> youTubePlayerView.wrapContent()
        }
    }

    companion object {
        const val VIDEO_DATA = "VIDEO_DATA"
    }
}