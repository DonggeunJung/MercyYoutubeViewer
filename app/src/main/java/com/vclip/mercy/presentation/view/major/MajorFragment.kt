package com.vclip.mercy.presentation.view.major

import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vclip.mercy.R
import com.vclip.mercy.data.KeywordVideos
import com.vclip.mercy.data.YtVideo
import com.vclip.mercy.databinding.FragmentMajorBinding
import com.vclip.mercy.presentation.base.BaseFragment

/**
 * A simple [Fragment] subclass.
 * Use the [MajorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MajorFragment : BaseFragment() {
    private lateinit var binding: FragmentMajorBinding
    private val arKeywordVideos = mutableListOf<KeywordVideos>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMajorBinding.inflate(inflater)

        setMockVideosData()

        initKeywordRecommends()
        return binding.root
    }

    private fun setMockVideosData() {
        var videos = mutableListOf<YtVideo>()
        var video = YtVideo("yM36wjQhWKM", "Niagara falls", "Denis")
        videos.add(video)
        video = YtVideo("OzAOzBNjtjo", "회복이 불가능한 2023년 외교!", "[팟빵] 매불쇼")
        videos.add(video)
        video = YtVideo("RAhroLEcrdo", "대중국 무역, 31년 만에 적자 / 미국의 '전기차 쇄국', 차라리 잘 된 이유 / '삼전' 8층 고지 눈앞?", "KBS News")
        videos.add(video)

        var keywordVideos = KeywordVideos("Science & Technology", R.drawable.shape001, videos)
        arKeywordVideos.add(keywordVideos)

        videos = mutableListOf<YtVideo>()
        video = YtVideo("rmynpQkqR4c", "[#벌거벗은세계사] (1시간) '개와 중국인은 출입 금지?' 과거 중국 역사 최악의 암흑기", "디글:Diggle")
        videos.add(video)
        video = YtVideo("SzAmGg2TVBg", "Break into NLP hosted by deeplearning.ai", "DeepLearningAI")
        videos.add(video)
        video = YtVideo("o54DWLdfokA", "7 Minute Korean Army Stew that Even a College Student Can Make!", "Aaron and Claire")
        videos.add(video)

        keywordVideos = KeywordVideos("Cooking", R.drawable.shape002, videos)
        arKeywordVideos.add(keywordVideos)

        videos = mutableListOf<YtVideo>()
        video = YtVideo("mRWxGCDBRNY", "이소라 - 바람이 분다", "HopeOfLetter")
        videos.add(video)
        video = YtVideo("SLvpSm2iZxE", "[전설의 무대 아카이브K] 김필, 방송 최초 OST 라이브 그때 그 아인", "스브스 트렌즈", startSeconds = 72)
        videos.add(video)
        video = YtVideo("5S_YxUAdlAk", "Lena Park (박정현) - Chandelier | Begin Again 3 (비긴어게인 3)", "So Hyang TV • 팬 채널")
        videos.add(video)

        keywordVideos = KeywordVideos("Music", R.drawable.shape003, videos)
        arKeywordVideos.add(keywordVideos)
    }

    private fun initKeywordRecommends() {
        arKeywordVideos.forEach {
            // Add Keyword title
            val tvKeywordTitle = TextView(this.requireContext())
            tvKeywordTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP,16f)
            tvKeywordTitle.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.black))
            tvKeywordTitle.setTypeface(null, Typeface.BOLD)
            val params: LinearLayout.LayoutParams =
                LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            params.setMargins(0, dpToPx(this.requireContext(), 40), 0, 0)
            tvKeywordTitle.layoutParams = params
            tvKeywordTitle.text = it.keyword
            tvKeywordTitle.setCompoundDrawablesWithIntrinsicBounds(it.iconId, 0, 0, 0);
            binding.layoutKeywordVideos.addView(tvKeywordTitle)

            // Add video RecyclerView for Keyword
            val rvKeywordVideo = RecyclerView(this.requireContext())
            rvKeywordVideo.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
            rvKeywordVideo.adapter = VideoHRvAdapter(it.videos)
            binding.layoutKeywordVideos.addView(rvKeywordVideo)
        }
    }

    companion object {
        fun dpToPx(context: Context, dp: Int): Int {
            return (dp * context.resources.displayMetrics.density).toInt()
        }
    }
}