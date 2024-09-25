package com.vclip.mercy.presentation.view.major

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vclip.mercy.R
import com.vclip.mercy.data.YtVideo
import com.vclip.mercy.presentation.view.videoplay.VideoPlayFragment


class VideoHRvAdapter(private val videos: List<YtVideo>)
    : RecyclerView.Adapter<VideoHRvAdapter.VH>() {

    override fun getItemCount(): Int {
        return videos.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater = LayoutInflater.from(parent.context)
        val itemView: View = inflater.inflate(R.layout.item_video_h, parent, false)
        return VH(itemView)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(videos[position])
    }

    class VH(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var video: YtVideo
        fun bind(video: YtVideo) {
            this.video = video
            val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
            tvTitle.text = video.title

            val tvAuthor = itemView.findViewById<TextView>(R.id.tvAuthor)
            tvAuthor.text = video.author

            val ivThumbnail = itemView.findViewById<ImageView>(R.id.ivThumbnail)
            Glide.with(itemView.context).load(video.thumbnailURL()).into(ivThumbnail)

            val layoutMain = itemView.findViewById<View>(R.id.layoutMain)
            val bundle = Bundle()
            bundle.putParcelable(VideoPlayFragment.VIDEO_DATA, video)
            layoutMain.setOnClickListener { _ ->
                Navigation.findNavController(layoutMain).navigate(R.id.action_majorFragment_to_videoPlayFragment, bundle)
            }
        }
    }

}